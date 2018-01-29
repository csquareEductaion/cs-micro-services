package com.csquare.user.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csquare.user.dao.UserRepository;
import com.csquare.user.model.User;
import com.csquare.user.service.IUserService;


@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserRepository iUserRepository;

    @Override
    public User addUser(User User) {
       
        // TODO Auto-generated method stub
        iUserRepository.create(User);
        return User;
    }

    @Override
    public User updateUser(User User) {

        iUserRepository.update(User);
        return User;
    }

    @Override
    public void deleteUser(String UserId) {

        iUserRepository.delete(UserId);
        ;
    }

    @Override
    public User getUserById(String id) {

        // TODO Auto-generated method stub
        return iUserRepository.findOne(id);
    }

    @Override
    public List<User> getAllUsers() {

        // TODO Auto-generated method stub
        return iUserRepository.findAll();
    }

    @Override
    public List<User> getAllUsers(int Offset, int limit) {

        // TODO Auto-generated method stub
        return iUserRepository.findAll(Offset, limit);
    }

}
