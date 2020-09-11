package com.bapb.controller;

import com.bapb.model.User;
import com.bapb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserResourceController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/rest/addUser",consumes = APPLICATION_JSON_VALUE ,produces = TEXT_PLAIN_VALUE ,method = RequestMethod.POST)
    public String addUser(@RequestBody User user){
        /*
        * Rest API for adding a new user at the registration page.
        * Asks for user name and phone and adds it in the table with auto generated uid.
        */
        int value = userService.add(user);
        return "User with Uid '"+value+" ' resource added successfully!";
    }

    @RequestMapping(value = "/rest/user/{uid}",produces = APPLICATION_JSON_VALUE ,method = RequestMethod.GET)
    public User readUserByUidAsJson(@PathVariable Integer uid){
        /*
        * Rest API for getting user credentials.
        * Searches the database for the particular uid and return user data.
        */
        User user = userService.readByUid(uid);
        return user;
    }

    @RequestMapping(value = "/rest/isUser/{uid}",produces = APPLICATION_JSON_VALUE ,method = RequestMethod.GET)
    public Boolean isUser(@PathVariable Integer uid){
        User user = userService.readByUid(uid);
        if(user!=null)
            return true;
        else
            return false;
    }

    @RequestMapping(value = "/rest/search/{name}/{phone}",produces = APPLICATION_JSON_VALUE ,method = RequestMethod.GET)
    public Boolean searchUser(@PathVariable String name,@PathVariable String phone){
        /*
        * Rest API for searching user credentials.
        * Searches the database for the particular user data and return if it exists.
        */
        User user = userService.searchByNameAndPhone(name,phone);
        if (user == null)
            return false;
        else
            return true;
    }

}
