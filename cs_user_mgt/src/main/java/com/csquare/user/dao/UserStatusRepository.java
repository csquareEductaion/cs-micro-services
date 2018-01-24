package com.csquare.user.dao;

import org.springframework.stereotype.Repository;

import com.csquare.framework.entity.BaseJpaRepository;
import com.csquare.user.model.UserStatus;

@Repository
public class UserStatusRepository extends BaseJpaRepository<UserStatus, String> {

}
