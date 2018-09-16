package com.spring.start.controller;

import com.spring.start.model.User;
import com.spring.start.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @ResponseBody
    @RequestMapping(value="/add",produces = {"application/json;charset=UTF-8"})
    public int addUser(User user){
        System.out.println(user.getUsername());
      return userService.addUser(user);
    }
    @ResponseBody
    @RequestMapping(value="/all",produces = {"application/json;charset=UTF-8"})
    public List<User>  getAllUser(){

       return  userService.findAllUsers();
    }



}
