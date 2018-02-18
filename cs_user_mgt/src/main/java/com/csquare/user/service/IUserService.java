package com.csquare.user.service;

import java.util.List;

import com.csquare.framework.search.SearchCriteria;
import com.csquare.user.model.User;


public interface IUserService {

    public User addUser(User user);

    public User updateUser(User user);

    public User saveUser(User user);

    public void deleteUser(String userId);

    public User getUserById(String id);

    public List<User> getAllUsers(int Offset, int limit);

    public List<User> searchUser(List<SearchCriteria> criterias, int offset, int limit, boolean allMatch);
}
