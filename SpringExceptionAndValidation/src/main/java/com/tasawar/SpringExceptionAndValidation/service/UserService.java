package com.tasawar.SpringExceptionAndValidation.service;

import com.tasawar.SpringExceptionAndValidation.dto.UserRequest;
import com.tasawar.SpringExceptionAndValidation.entity.User;
import com.tasawar.SpringExceptionAndValidation.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.UnknownServiceException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public User saveUser(UserRequest request){
        User user = User.build(0,request.getName(), request.getEmail(), request.getMobile(), request.getGender(), request.getAge(), request.getNationality());
      return   repository.save(user);
    }
    public List<User> getAllUsers(){
        return repository.findAll();
    }
    public User getSingleUser(int id){
        User user = repository.findById(id).orElseThrow();
        return user;
    }

}
