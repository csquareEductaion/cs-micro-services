package com.csquare.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csquare.user.model.UserStatus;


public interface UserStatusRepository extends JpaRepository<UserStatus, String> {

}
