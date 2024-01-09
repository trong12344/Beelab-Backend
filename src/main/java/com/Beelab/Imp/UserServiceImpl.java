package com.Beelab.Imp;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import com.Beelab.Common.PageResponse;
import com.Beelab.dto.userdto.ChangePasswordDTO;
import com.Beelab.dto.userdto.ForgetPasswordDTO;
import com.Beelab.dto.userdto.ResetPasswordDTO;
import com.Beelab.dto.userdto.UserDTO;
import jakarta.persistence.criteria.Predicate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import com.Beelab.DAO.UserDAO;
import com.Beelab.Entity.User;
import com.Beelab.Service.UserService;

import javax.swing.text.html.Option;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDAO userDAO;
	@Value("${email.username}")
	private String emailUsername;
	@Value("${email.password}")
	private String emailPassword;
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	ModelMapper modelMapper = new ModelMapper();

	@Override
	public User create(User user) {
		return userDAO.save(user);
	}

	@Override
	public User update(User user) {
		return userDAO.save(user);
	}

	@Override
	public User findOneById(int id) {
		return userDAO.findById(id).get();
	}

	@Override
	public User findOneByPhone(String phoneNumber) {
		return userDAO.findByPhone(phoneNumber);
	}

	@Override
	public User findOneByUsername(String fullName) {
		return userDAO.findByUserName(fullName);
	}

	@Override
	public User findOneByEmail(String email) {
		return userDAO.findByEmail(email);
	}

	@Override
	public ResponseEntity<List<UserDTO>> getListUser() {
		List<User> users = userDAO.getListUser();
		List<UserDTO> userDTO = users.stream().map(source -> modelMapper.map(source, UserDTO.class)).collect(Collectors.toList());
		return ResponseEntity.ok(userDTO);
	}

	public PageResponse<User> search(String fullName, String email, String phoneNumber,int page, int size){
		Pageable pageable = PageRequest.of(page,size, Sort.by(Sort.Direction.ASC,"id"));
		Specification<User> query = (root, criteriaQuery, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
			if(fullName != null){
				predicates.add(criteriaBuilder.like(root.get("full_name"),fullName));
			}
			if(email != null){
				predicates.add(criteriaBuilder.equal(root.get("email"),email));
			}
			if(phoneNumber != null){
				predicates.add(criteriaBuilder.like(root.get("phone_number"),phoneNumber));
			}
			return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));//Chưa hiểu chỗ này
		};
		Page<User> listUser = userDAO.findAll(query,pageable);
		List<User> result = listUser.getContent();
		return PageResponse.<User>builder()
				.totalPages(listUser.getTotalPages())
				.pageSize(size)
				.totalElements(listUser.getTotalElements())
				.data(result)
				.build();
	}

	@Override
	public User changePassword(int id, ChangePasswordDTO changePasswordDTO) {
		String decodedCurrentPassword = new String(Base64.getDecoder().decode(changePasswordDTO.getCurrentPassword()));
		String decodedNewPassword = new String(Base64.getDecoder().decode(changePasswordDTO.getNewPassword()));
		String decodedConfirmPassword = new String(Base64.getDecoder().decode(changePasswordDTO.getConfirmPassword()));// Decode từ Base64 về chuỗi

		Optional<User> optionalUser = userDAO.findById(id);
		if(!optionalUser.isPresent()) throw new NullPointerException("Không tìm thấy user");
		User user = optionalUser.get();
		if(decodedCurrentPassword.equals(decodedNewPassword)) throw new IllegalStateException("Mật khẩu trùng");
		if(!passwordEncoder.matches(decodedCurrentPassword, user.getPassword())) throw new IllegalStateException("Mật khẩu không hợp lệ");
		if(!decodedNewPassword.equals(decodedConfirmPassword)) throw new IllegalStateException("Mật khẩu không khớp");
		user.setPassword(passwordEncoder.encode(decodedNewPassword));
		return userDAO.save(user);
		//Front end bắt rỗng + Backend bắt rỗng 11
	}

	@Override
	public User forgetPassword(ForgetPasswordDTO forgetPasswordDTO) {
		User tempUser = userDAO.findByEmail(forgetPasswordDTO.getEmail());
		Optional<User> optionalUser = Optional.ofNullable(userDAO.findByEmail(tempUser.getEmail()));
		if(!optionalUser.isPresent()){
			throw new NullPointerException();
		}
		User user = optionalUser.get();
		StringBuilder sb = new StringBuilder(6);
		for(int i = 0; i < 6; i++){
			int digit = ThreadLocalRandom.current().nextInt(10);
			sb.append(digit);
		}//Sửa logic random số
		String verificationCode = sb.toString();
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(emailUsername, emailPassword);
			}
		});
		try {
			// Tạo đối tượng message
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(emailUsername));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(forgetPasswordDTO.getEmail()));
			message.setSubject("Verification Code From BeeLab");
			message.setText("Your verification code is: " + verificationCode);

			// Gửi email
			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		user.setVerify_code(verificationCode);
		return userDAO.save(user);
	}

	@Override
	public User resetPassword(ResetPasswordDTO resetPasswordDTO) {
		Optional<User> optionalUser = Optional.ofNullable(userDAO.findByEmail(resetPasswordDTO.getEmail()));//Lấy user từ email
		if(!optionalUser.isPresent()){
			throw new NullPointerException("Không tìm thấy email");
		}
		User user = optionalUser.get();
		if(!resetPasswordDTO.getVerificationCode().equals(user.getVerify_code())) { //Check verify code
			throw new IllegalStateException("Verification Code không hợp lệ");
		}
		String decodedNewPassword = new String(Base64.getDecoder().decode(resetPasswordDTO.getNewPassword()));
		String decodedConfirmPassword = new String(Base64.getDecoder().decode(resetPasswordDTO.getConfirmPassword()));// Decode từ Base64 về chuỗi
		if(!decodedNewPassword.equals(decodedConfirmPassword)) { //Kiểm tra mật khẩu mới
			throw new IllegalStateException("Mật khẩu không khớp");
		}
		user.setPassword(passwordEncoder.encode(decodedNewPassword));
		return userDAO.save(user);
	}

	//Thiếu trường status
//	@Override
//	public User delete(int id){
//		Optional<User> existingUserOptional = userDAO.findById(id);
//		if(existingUserOptional.isPresent()){
//			User existingUser = existingUserOptional.get();
//			existingUser.setStatus(1);
//			userDAO.save(existingUser);
//			return  existingUser;
//		}else throw new NoSuchElementException("User not found with ID: " + id);
//	}

//	@Override
//	public User changePassword(User userChangePasswordDTO, int userId) {
//		 Optional<User> optionalUser = userDAO.findById(userId);
//	        if (optionalUser.isPresent()) {
//	            User existingUser = optionalUser.get();
//	            String newPassword = userChangePasswordDTO.getPassword();
//	            existingUser.setPassword(newPassword);
//	            userDAO.save(existingUser);
//	            return existingUser;
//	        } else {
//	            throw new NoSuchElementException("User not found with ID: " + userId);
//	        }
//	}
}
