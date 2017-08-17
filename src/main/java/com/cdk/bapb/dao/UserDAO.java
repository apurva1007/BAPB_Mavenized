package com.cdk.bapb.dao;

import com.cdk.bapb.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserDAO {

    @PersistenceContext
    EntityManager entityManager;

    public int update(User user){
        entityManager.merge(user);
        return user.getUid();
    }

    public int save(User user){
        entityManager.persist(user);
        return user.getUid();
    }

    public User selectByUid(int uid){
        return entityManager.find(User.class,uid);
    }

    public void delete(int uid) {
        User user = entityManager.find(User.class,uid);
        entityManager.remove(user);
    }

}
