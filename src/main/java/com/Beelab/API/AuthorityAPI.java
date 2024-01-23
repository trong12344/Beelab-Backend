package com.Beelab.API;

import com.Beelab.Common.HandleResponse;
import com.Beelab.Entity.User;
import com.Beelab.Imp.UserS;
import com.Beelab.dto.User.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
public class AuthorityAPI {
    @Autowired
    PasswordEncoder bCryptPasswordEncoder;


    @Autowired
    UserS userS;

//    @PostMapping("/signin")
//    public HandleResponse<Void> login(@RequestBody loginDto loginDto){
//        userS.login(loginDto);
//        return HandleResponse.ok();
//    }

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<User> authenticateUser(@Valid @RequestBody loginDto loginDto){

        return ResponseEntity.ok(userS.login(loginDto).get());
    }
}
