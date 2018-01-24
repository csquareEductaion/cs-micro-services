package com.csquare.user.dao;

import org.springframework.stereotype.Repository;

import com.csquare.framework.entity.BaseJpaRepository;
import com.csquare.user.model.UserRole;

@Repository
public class UserRoleRepository extends BaseJpaRepository<UserRole, String> {

}

