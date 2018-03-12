package com.csquare.user.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "user_session", schema = "user_mgt")


public class UserSession {

	@Id
	@Column(name = "session_id")
    private String sessionId;

	@Column(name = "user_id")
    private String userId;

	@Column(name = "update_time")
    private String updateTime;
    
    @Column(name = "user_email")
    private String userEmail;
    
    @Column(name= "user_role")
    private String userRole;

    public String getSessionId() {

        return sessionId;
    }

    public void setSessionId(String sessionId) {

        this.sessionId = sessionId;
    }

    public String getUserId() {

        return userId;
    }

    public void setUserId(String userId) {

        this.userId = userId;
    }

    public String getUpdateTime() {

        return updateTime;
    }

    public void setUpdateTime(String updateTime) {

        this.updateTime = updateTime;
    }

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
    

}
