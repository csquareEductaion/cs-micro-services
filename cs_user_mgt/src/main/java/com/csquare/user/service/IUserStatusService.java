package com.csquare.user.service;

import com.csquare.user.model.UserStatus;

public interface IUserStatusService {

    public UserStatus addUserStatus(UserStatus userstatus);

    public UserStatus updateUserStatus(UserStatus userstatus);
    
    public void deleteUserStatus(String userstatusId);
    
    public UserStatus getUserStatusById(String id);

}
