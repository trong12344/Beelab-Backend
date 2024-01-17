package com.Beelab.Common;

import com.Beelab.DAO.UserDAO;
import com.Beelab.Entity.User;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService, UserDetailsPasswordService {
    private UserDAO IUserRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        var useByEmail = IUserRepository.findByEmail(username);
        if (useByEmail.isPresent()) {
            return useByEmail.get();
        }
        throw new UsernameNotFoundException("User not found");
    }

    @Override
    public UserDetails updatePassword(UserDetails user, String newPassword) {
        Optional<User> userEntity = IUserRepository.findByEmail(user.getUsername());
        if (userEntity.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        userEntity.get().setPassword_hash(passwordEncoder.encode(newPassword));
        IUserRepository.save(userEntity.get());
        return userEntity.get();
    }
}
