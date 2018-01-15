package com.csquare.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csquare.user.model.User;


public interface UserRepository extends JpaRepository<User, String> {

}
