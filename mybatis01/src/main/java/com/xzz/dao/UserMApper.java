package com.xzz.dao;

import com.xzz.pojo.User;

import java.util.List;

public interface UserMApper {
    //查询所有用户
    List<User> getUserList();

    //根据id查询用户
    User getUserById(int id);

    //增加用户
    void addUser(User user);

    //更新用户
    void updateUser(User user);

    //删除用户
    void deleteUser(int id);
}
