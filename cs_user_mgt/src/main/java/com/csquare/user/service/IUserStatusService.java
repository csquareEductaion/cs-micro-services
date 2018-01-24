package com.csquare.user.service;

import java.util.List;

import com.csquare.user.model.UserStatus;

public interface IUserStatusService {

    public UserStatus addUserStatus(UserStatus userstatus);

    public UserStatus updateUserStatus(UserStatus userstatus);
    
    public void deleteUserStatus(String userstatusId);
    
    public UserStatus getUserStatusById(String id);
    
    public List<UserStatus> getAllUserStatus();
    
    public List<UserStatus> getAllUserStatus(int Offset, int limit);

}
