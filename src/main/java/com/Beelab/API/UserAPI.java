package com.Beelab.API;

import java.security.SignatureException;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;

import com.Beelab.Common.HandleResponse;
import com.Beelab.Common.PageResponse;
import com.Beelab.Imp.UserS;
import com.Beelab.Service.OrderServ;
import com.Beelab.dto.User.RegisterDto;
import com.Beelab.dto.User.ResetPasswordDto;
import com.Beelab.dto.User.loginDto;
import com.Beelab.dto.orderdto.OrderDto;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.Beelab.Entity.User;



@CrossOrigin("*")
@RestController
@RequestMapping("/accounts")
public class UserAPI {
    @Autowired
    UserS userS;
    @Autowired
    OrderServ orderServ;
    @PostMapping("register")
    public ResponseEntity<User> Register(@RequestBody RegisterDto registerDto){
        return ResponseEntity.ok(userS.create(registerDto).orThrow());
    }

    @PostMapping("forgot-password")
    public ResponseEntity<Void> forgotPassword(@RequestParam String email){
        return ResponseEntity.ok(userS.forgetPassword(email).orThrow());
    }

    @GetMapping("reset-password")
    public HandleResponse<Void> resetPassword(@ParameterObject ResetPasswordDto resetPasswordDto) throws Exception {
        userS.resetPassword(resetPasswordDto);
        return HandleResponse.ok();
    }

    @GetMapping("my-order")
    public ResponseEntity<List<OrderDto>> getMyOrder(){
        return ResponseEntity.ok(orderServ.getMyOrder().orThrow());
    }


}