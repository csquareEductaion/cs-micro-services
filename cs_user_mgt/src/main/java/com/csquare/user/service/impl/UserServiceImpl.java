package com.csquare.user.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csquare.framework.search.SearchCriteria;
import com.csquare.user.dao.UserRepository;
import com.csquare.user.model.User;
import com.csquare.user.service.IUserService;


@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserRepository iUserRepository;

    @Override
    public User addUser(User User) {

        User.setUserName(User.getEmail());
        User.setPassword(UUID.randomUUID().toString());
        iUserRepository.create(User);
        return User;
    }

    @Override
    public User updateUser(User User) {

        iUserRepository.update(User);
        return User;
    }

    // @Override
    // public User saveUser(User user) {
    // String email = user.getEmail();
    // HashMap<String, String> paramsMap = new HashMap<String, String>();
    // paramsMap.put("email", email);
    // List<User> userListFromDB = iUserRepository.findByHQLNamedQuery("getUserByEmail", paramsMap, false, -1, -1);
    // if (CommonUtil.isEmpty(userListFromDB)) {
    // return addUser(user);
    // }
    //
    // User userFromDB = userListFromDB.get(0);
    // userFromDB.setAlternate_phone(user.getAlternate_phone());
    // userFromDB.setCity(user.getCity());
    // userFromDB.setEmail(email);
    // userFromDB.setFirstName(user.getFirstName());
    // userFromDB.setGender(user.getGender());
    // userFromDB.setIsActive(user.getIsActive());
    // userFromDB.setLastName(user.getLastName());
    // userFromDB.setPhone(user.getPhone());
    //
    // return updateUser(userFromDB);
    //
    // }

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
    public List<User> getAllUsers(int Offset, int limit) {

        return iUserRepository.findAll(Offset, limit);
    }

    @Override
    public List<User> searchUser(List<SearchCriteria> criterias, int offset, int limit, boolean allMatch) {

        List<User> userList = iUserRepository.search(criterias, offset, limit, allMatch);
        return userList;
    }

    @Override
    public User saveUser(User user) {

        // TODO Auto-generated method stub
        return null;
    }

}
