package com.cdk.bapb.service;

import com.cdk.bapb.dao.CarDAO;
import com.cdk.bapb.dao.UserDAO;
import com.cdk.bapb.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class UserServiceTest {

    UserService userService = new UserService();

    User user1= new User("Binay","9090896166");
    User user2= new User("Priyal","9090899166");
    User user3= new User("Apurva","9090999166");
    User user4= new User("Apurva","9090999166");


    @Test
    public void testAdd() throws Exception {
        UserDAO mock = Mockito.mock(UserDAO.class);
        Mockito.when(mock.save((User) Matchers.anyObject())).thenReturn(user1.getUid());
        userService.setUserDAO(mock);

        int userId1 = userService.add(user1);
        Assert.assertEquals(userId1,user1.getUid());

    }

    @Test
    public void testModify() throws Exception {
        UserDAO mock = Mockito.mock(UserDAO.class);
        Mockito.when(mock.update((User) Matchers.anyObject())).thenReturn(user3.getUid());
        userService.setUserDAO(mock);

        int userId4 = userService.modify(user4);
        Assert.assertEquals(userId4,user3.getUid());

    }

    @Test
    public void testReadByUid() throws Exception {
        UserDAO mock = Mockito.mock(UserDAO.class);
        Mockito.when(mock.selectByUid(Matchers.anyInt())).thenReturn(user1);
        userService.setUserDAO(mock);

        User testUser = userService.readByUid(1);
        Assert.assertEquals(testUser,user1);
    }

    @Test
    public void testRemove() throws Exception {
        UserDAO mock = Mockito.mock(UserDAO.class);
        Mockito.when(mock.selectByUid(Matchers.anyInt())).thenReturn(user1);
        userService.setUserDAO(mock);

        userService.remove(user1.getUid());
        User testUser = userService.readByUid(user1.getUid());
        Assert.assertEquals(testUser,null);
    }

}