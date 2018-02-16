package com.csquare.user.dao;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.csquare.user.model.User;
import com.csquare.framework.entity.BaseJpaRepository;


@Repository
public interface UserRepository extends JpaRepository<User, String> {

	
	@Query(value = "select * from user_mgt.user where user_mgt.user.email =:email", nativeQuery = true)
	public User findByEmail(@Param("email")String email);
}
