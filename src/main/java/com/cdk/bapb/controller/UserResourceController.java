package com.cdk.bapb.controller;

import com.cdk.bapb.model.User;
import com.cdk.bapb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserResourceController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/rest/update/{uid}",consumes = APPLICATION_JSON_VALUE ,produces = TEXT_PLAIN_VALUE ,method = RequestMethod.PUT)
    public String updateUser(@RequestBody User user, @PathVariable int uid){
        user.setUid(uid);
        int value = userService.modify(user);
        return "User with Uid '"+value+" ' resource updated successfully!";
    }

    @RequestMapping(value = "/rest/addUser",consumes = APPLICATION_JSON_VALUE ,produces = TEXT_PLAIN_VALUE ,method = RequestMethod.POST)
    public String addUser(@RequestBody User user){
        System.out.println(user);
        int value = userService.add(user);
        return "User with Uid '"+value+" ' resource added successfully!";
    }

    @RequestMapping(value = "/rest/user/{uid}",produces = APPLICATION_JSON_VALUE ,method = RequestMethod.GET)
    public User readUserByUidAsJson(@PathVariable Integer uid){
        System.out.println("Uid is : "+uid);
        User user = userService.readByUid(uid);
        System.out.println("User read by id returns: " + user);
        return user;
    }

    @RequestMapping(value = "/rest/isUser/{uid}",produces = APPLICATION_JSON_VALUE ,method = RequestMethod.GET)
    public Boolean isUser(@PathVariable Integer uid){
        System.out.println("Uid is : "+uid);
        User user = userService.readByUid(uid);
        System.out.println("User read by id returns: " + user);
        if(user!=null)
            return true;
        else
            return false;
    }

    @RequestMapping(value = "/rest/delete/{uid}",produces = TEXT_PLAIN_VALUE ,method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable int uid){
        userService.remove(uid);
        return "User with Uid '"+uid+"'resource deleted successfully!";
    }

    @RequestMapping(value = "/rest/search/{name}/{phone}",produces = APPLICATION_JSON_VALUE ,method = RequestMethod.GET)
    public Boolean searchUser(@PathVariable String name,@PathVariable String phone){
        System.out.println(userService.searchByNameAndPhone(name,phone));
        User user = userService.searchByNameAndPhone(name,phone);
        if (user == null)
            return false;
        else
            return true;
    }

}
