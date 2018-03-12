package com.csquare.user.dao;

import org.springframework.stereotype.Repository;

import com.csquare.framework.entity.BaseJpaRepository;
import com.csquare.user.model.UserSession;

@Repository
public class UserSessionRepository extends BaseJpaRepository <UserSession, String> {

}
