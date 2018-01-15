package com.csquare.user.service;

import com.csquare.user.model.UserRole;

public interface IUserRoleService {

    public UserRole addUserRole(UserRole userrole);

    public UserRole updateUserRole(UserRole userrole);
    
    public void deleteUserRole(String userroleId);
    
    public UserRole getUserRoleById(String id);

}
