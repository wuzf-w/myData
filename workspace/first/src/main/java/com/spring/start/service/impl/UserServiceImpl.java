package com.spring.start.service.impl;

import com.github.pagehelper.PageHelper;
import com.spring.start.mapper.UserMapper;
import com.spring.start.model.User;
import com.spring.start.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public int addUser(User user) {
        return userMapper.insertSelective(user);
    }
    /*
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
     * 只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * pageNum 开始页数
     * pageSize 每页显示的数据条数
     * */
    public List<User> findAllUsers() {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
//        PageHelper.startPage(pageNum,pageSize);
        return userMapper.findAllUsers();
    }
}
