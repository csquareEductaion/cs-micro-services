package com.csquare.user.service;

import com.csquare.user.model.User;

public interface IUserService {

    public User addUser(User user);

    public User updateUser(User user);
    
    public void deleteUser(String userId);
    
    public User getUserById(String id);

}
