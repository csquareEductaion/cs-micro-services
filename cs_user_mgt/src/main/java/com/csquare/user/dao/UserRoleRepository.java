package com.csquare.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csquare.user.model.User;
import com.csquare.user.model.UserRole;


public interface UserRoleRepository extends JpaRepository<UserRole, String> {

}
