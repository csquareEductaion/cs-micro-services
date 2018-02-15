package com.csquare.user.dao;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.csquare.user.model.User;
import com.csquare.framework.entity.BaseJpaRepository;


@Repository
public interface UserRepository extends JpaRepository<User, String> {

	public User findByEmail(String email);
}
