package com.personal.blog.controllers;

import com.personal.blog.DTO.UserDTO;
import com.personal.blog.services.UsersService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    UsersService usersService;

    @PostMapping("")
    ResponseEntity<UserDTO.LoginUserResponse> signupUser(
            @RequestBody UserDTO.CreateUserRequest request
    ) {
        var response = usersService.signupUser(request);
        return ResponseEntity.created(URI.create("/users/" + response.getId())).body(response);
    }

    @PostMapping("/login")
    ResponseEntity<UserDTO.LoginUserResponse> loginUser(
            @RequestBody UserDTO.LoginUserRequest request
    ){
        var response = usersService.loginUser(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/@{username}", produces = "application/json")
    ResponseEntity<UserDTO.GetUserResponse> getUser(
            @PathVariable ("username") String username
    ){
        var response = usersService.findUserByUsername(username);
        return ResponseEntity.ok(response);
    }

}
