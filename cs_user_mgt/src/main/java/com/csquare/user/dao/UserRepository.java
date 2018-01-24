package com.csquare.user.dao;

import org.springframework.stereotype.Repository;

import com.csquare.user.model.User;
import com.csquare.framework.entity.BaseJpaRepository;


@Repository
public class UserRepository extends BaseJpaRepository<User, String> {

}
