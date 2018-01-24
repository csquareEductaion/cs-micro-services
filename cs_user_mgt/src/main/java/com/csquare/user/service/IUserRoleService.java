package com.csquare.user.service;

import java.util.List;

import com.csquare.user.model.UserRole;

public interface IUserRoleService {

    public UserRole addUserRole(UserRole userrole);

    public UserRole updateUserRole(UserRole userrole);
    
    public void deleteUserRole(String userroleId);
    
    public UserRole getUserRoleById(String id);
    
    public List<UserRole> getAllUserRoles();
    
    public List<UserRole> getAllUserRoles(int Offset, int limit);

}
