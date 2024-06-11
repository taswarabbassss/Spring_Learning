package com.tasawar.SpringExceptionAndValidation.repository;

import com.tasawar.SpringExceptionAndValidation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
