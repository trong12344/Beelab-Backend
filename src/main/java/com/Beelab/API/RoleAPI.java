package com.Beelab.API;

import com.Beelab.Common.HandleResponse;
import com.Beelab.Entity.User;
import com.Beelab.Imp.UserS;
import com.Beelab.dto.User.AddorRemoveRoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/role")
public class RoleAPI {
    @Autowired
    UserS userS;

    @PutMapping("add-role")
    public ResponseEntity<HandleResponse<Void>> addRole(@RequestBody AddorRemoveRoleDto addorRemoveRoleDto){
        return ResponseEntity.ok(userS.AddRoleToUser(addorRemoveRoleDto));
    }

    @PutMapping("remove-role")
    public ResponseEntity<HandleResponse<Void>> RemoveRole(@RequestBody AddorRemoveRoleDto addorRemoveRoleDto){
        return ResponseEntity.ok(userS.RemoveRoleFormUser(addorRemoveRoleDto));
    }



}
