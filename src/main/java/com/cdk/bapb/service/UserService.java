package com.cdk.bapb.service;

import com.cdk.bapb.dao.UserDAO;
import com.cdk.bapb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    public int add(User user){
        return userDAO.save(user);
    }

    @Transactional
    public int modify(User user){
        return userDAO.update(user);
    }

    @Transactional
    public User readByUid(Integer uid){
        return userDAO.selectByUid(uid);
    }

    @Transactional
    public void remove(int uid) {
        userDAO.delete(uid);
    }

    @Transactional
    public User searchByNameAndPhone(String name, String phone){
       return userDAO.search(name,phone);
    }
}
