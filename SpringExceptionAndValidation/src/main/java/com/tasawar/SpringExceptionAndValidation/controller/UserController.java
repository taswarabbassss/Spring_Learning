package com.tasawar.SpringExceptionAndValidation.controller;

import com.tasawar.SpringExceptionAndValidation.dto.UserRequest;
import com.tasawar.SpringExceptionAndValidation.entity.User;
import com.tasawar.SpringExceptionAndValidation.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest request){

        return new ResponseEntity<>(userService.saveUser(request),HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){

        return  new ResponseEntity<>(userService.getAllUsers(),HttpStatus.resolve(200));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getSingleUser(@PathVariable int id){
        return  new ResponseEntity<>(userService.getSingleUser(id),HttpStatus.OK);

    }



}
