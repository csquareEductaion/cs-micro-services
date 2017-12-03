package com.csqaure.ums.audit;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.apache.log4j.Logger;

import com.csquare.ums.dto.UserInfo;
import com.csquare.ums.entity.BaseEntity;

public class SpringAuditListener {

	
	
	private Logger logger = Logger.getLogger(SpringAuditListener.class);
	@PrePersist
	public void prePersist(BaseEntity  entity) {
		logger.info("Inside prePersist");
		UserInfo userInfo = SecurityUtil.getUserInfo();
		if(Objects.nonNull(userInfo)) {
			entity.setCreatedBy(userInfo.getUsername());	
			//entity.setHierRelation(userInfo.getHierRelation());
		}
		entity.setCreatedDate(LocalDateTime.now());
	}
	
	@PreUpdate
	public void preUpdate(BaseEntity entity) {
		logger.info("Inside preUpdate");
		UserInfo userInfo = SecurityUtil.getUserInfo();
		if(Objects.nonNull(userInfo)) {
			entity.setUpdatedBy(userInfo.getUsername());
		}
		entity.setUpdatedDate(LocalDateTime.now());
	}

	
	
}
