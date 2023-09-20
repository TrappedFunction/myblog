package com.tf.service;


import com.tf.pojo.User;


public interface UserService {

    boolean checkPassword(User user);
    boolean Register(User user);

    boolean DeletedUser(String account);
}
