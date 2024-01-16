package com.Beelab.Imp;


import com.Beelab.Common.HandleResponse;
import com.Beelab.Common.JWT.JwtService;
import com.Beelab.Common.mail.MailService;
import com.Beelab.DAO.RoleDAO;
import com.Beelab.DAO.UserDAO;
import com.Beelab.Entity.Role;
import com.Beelab.Entity.User;
import com.Beelab.dto.User.AddorRemoveRoleDto;
import com.Beelab.dto.User.RegisterDto;
import com.Beelab.dto.User.ResetPasswordDto;
import com.Beelab.dto.User.loginDto;
import com.Beelab.dto.userdto.ChangePasswordDTO;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.server.ResponseStatusException;
import java.security.SignatureException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;


@Service
@AllArgsConstructor
public class UserS {
    @Autowired
    UserDAO userDAO;
    @Autowired
    RoleDAO roleDAO;
    @Autowired
    AuthenticationManager authenticationManager;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final MailService mailService;

    private final UserDetailsService userDetailService;

    private final UserDetailsPasswordService userDetailsService;



    public HandleResponse<Void> RemoveRoleFormUser(AddorRemoveRoleDto addorRemoveRoleDto){
        User user = userDAO.findById(addorRemoveRoleDto.getUserId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        Role role = roleDAO.findById(addorRemoveRoleDto.getRole()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Role not found"));
        for(Role r : user.getRoles()){
            if (r.getNormalizedName().equals(role.getNormalizedName())){
                user.getRoles().remove(role);
            }
        }
        userDAO.save(user);
        return HandleResponse.SuccesMessage("Gỡ role thành công");
    }

    public HandleResponse<Void> AddRoleToUser(AddorRemoveRoleDto addorRemoveRoleDto){
        Optional<User> user = userDAO.findById(addorRemoveRoleDto.getUserId());
        if(user.isEmpty()){
            return HandleResponse.error("Không tìm thấy người dùng");
        }
        Role role = roleDAO.findById(addorRemoveRoleDto.getRole()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Role not found"));

        user.get().getRoles().add(role);
        userDAO.save(user.get());
        return HandleResponse.SuccesMessage("Đã thêm role thành công");
    }

    public HandleResponse<User> create(RegisterDto registerDto){
        Optional<User> existedUser = userDAO.findByEmail(registerDto.getEmail());
        if (existedUser.isPresent()){
            return HandleResponse.error("Email đã tồn tại");
        }
        User user = User.builder()
                .full_name(registerDto.getFullName())
                .email(registerDto.getEmail())
                .password_hash(passwordEncoder.encode(registerDto.getRawPassword()))
                .roles(List.of(roleDAO.findByName("ROLE_CUSTOMER").orElseThrow()))
                .build();
        return HandleResponse.ok(userDAO.save(user));
    }

    public HandleResponse<Void> forgetPassword(String email){
        Optional<User> user = userDAO.findByEmail(email);
        if (user.isEmpty()){
            return HandleResponse.error("Email không tồn tại");
        }
        Map<String, Object> claims = new HashMap<>();
        claims.put("email", user.get().getEmail());
        claims.put("userId", user.get().getId());

        String token = jwtService.generateToken(claims, 60 * 60 * 1000);
        String to = user.get().getEmail();
        String subject = "Reset Password";
        String url = "http://localhost:8080/accounts/reset-password?token=" +token;
        String content = "Click vào link sau để reset password " + url;
        CompletableFuture.runAsync(() ->{
            try {
                mailService.sendEmail(to, subject, content);
            }catch (MessagingException e){
                e.printStackTrace();
            }
        });

        return HandleResponse.ok();
    }
    public HandleResponse<Void> resetPassword(ResetPasswordDto resetPasswordDto) throws Exception {
        String email;
        try {
            email = jwtService.getValue(resetPasswordDto.getToken(), c -> c.get("email", String.class));
            if (email.isEmpty() || email == null){
                return HandleResponse.error("Token không hợp lệ");
            }
        }catch (SignatureException e){
            return HandleResponse.error("Token không hợp lệ");
        }catch (ExpiredJwtException e){
            return HandleResponse.error("Token đã hết hạn");
        }
        var user = userDetailService.loadUserByUsername(email);
        userDetailsService.updatePassword(user, resetPasswordDto.getNewPassword());
        return HandleResponse.SuccesMessage("Đổi mật khẩu thành công");
    }

    public HandleResponse<Void> changePassword(ChangePasswordDTO changePasswordDTO){
       return null;
    }

    public HandleResponse<Void> login(loginDto loginDto){
        Optional<User> user = userDAO.findByEmail(loginDto.getUsername());
        if(user.isEmpty()){
            return HandleResponse.error("Không tìm thấy tài khoản");
        }
        if(!passwordEncoder.matches(loginDto.getPassword(), user.get().getPassword_hash())){
            return HandleResponse.error("Mật khẩu sai");
        }
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return HandleResponse.SuccesMessage("Đăng nhập thành công");
    }
}
