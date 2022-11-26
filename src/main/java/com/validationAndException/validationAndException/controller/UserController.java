package com.validationAndException.validationAndException.controller;

import com.validationAndException.validationAndException.dto.UserDto;
import com.validationAndException.validationAndException.entity.User;
import com.validationAndException.validationAndException.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserDto userDto){
        return new ResponseEntity<>(userService.saveUser(userDto), HttpStatus.CREATED);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<User>> getAllUser(){
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> findByUserId(@PathVariable("id") int id){
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }
}
