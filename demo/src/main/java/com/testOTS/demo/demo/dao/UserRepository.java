package com.testOTS.demo.demo.dao;

import com.testOTS.demo.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
  
  User findByUsernameAndPassword(String username, String password);

}
