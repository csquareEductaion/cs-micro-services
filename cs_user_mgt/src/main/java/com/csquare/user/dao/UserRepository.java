package com.csquare.user.dao;

import org.springframework.stereotype.Repository;

import com.csquare.framework.entity.BaseJpaRepository;
import com.csquare.user.model.User;


@Repository
public class UserRepository extends BaseJpaRepository<User, String> {

}
