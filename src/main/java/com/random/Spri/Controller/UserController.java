package com.random.Spri.Controller;


import com.random.Spri.Dto.UserDto;
import com.random.Spri.Model.User;
import com.random.Spri.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public User addUser (@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        UserDto user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/getAllUser")
    public ResponseEntity<List<UserDto>> getAllUsers() throws Exception {
        List<UserDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // Update a user
    @PutMapping("/updateUser/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody User user) {
        UserDto updatedUser = userService.updateUser(id, user);
        return ResponseEntity.ok(updatedUser);
    }

    // Delete a user
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
