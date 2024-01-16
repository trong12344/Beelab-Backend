package com.Beelab.API;

import java.util.List;
import java.util.Optional;

import com.Beelab.Common.HandleResponse;
import com.Beelab.Imp.UserS;
import com.Beelab.dto.User.loginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
public class AuthorityAPI {
    @Autowired
    UserS userS;



    @PostMapping("/login")
    public HandleResponse<Void> login(@RequestBody loginDto loginDto){
        userS.login(loginDto);
        return HandleResponse.ok();
    }


}
