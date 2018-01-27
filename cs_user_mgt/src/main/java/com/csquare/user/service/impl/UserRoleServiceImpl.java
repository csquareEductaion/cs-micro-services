package com.csquare.user.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csquare.user.dao.UserRoleRepository;
import com.csquare.user.model.UserRole;
import com.csquare.user.service.IUserRoleService;


@Service
public class UserRoleServiceImpl implements IUserRoleService {

    @Autowired
    UserRoleRepository iUserRepository;

    @Override
    public UserRole addUserRole(UserRole userrole) {

    	String pk=UUID.randomUUID().toString();
    	userrole.setPk(pk);
        // TODO Auto-generated method stub
        iUserRepository.save(userrole); 
        return userrole;
    }
    
    @Override
    public UserRole updateUserRole(UserRole userrole) {
	
        iUserRepository.save(userrole);
        return userrole;
    }
    
    @Override
    public void deleteUserRole(String UserId) {
	
        iUserRepository.delete(UserId);;
    }

    @Override
    public UserRole getUserRoleById(String id) {

        // TODO Auto-generated method stub
        return iUserRepository.findOne(id);
    }

	@Override
	public List<UserRole> getAllUserRoles() {
		// TODO Auto-generated method stub
		return iUserRepository.findAll();
	}

	@Override
	public List<UserRole> getAllUserRoles(int Offset, int limit) {
		// TODO Auto-generated method stub
		return iUserRepository.findAll("getAllUserRoles", Offset, limit);
	}

}
