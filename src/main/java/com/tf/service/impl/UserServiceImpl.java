package com.tf.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tf.dao.UerDao;
import com.tf.pojo.User;
import com.tf.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UerDao uerDao;
    @Override
    public boolean checkPassword(User user) {
        String password = uerDao.selectByAccount(user.getAccount());
        String salt = uerDao.selectSaltByAccount(user.getAccount());
        return DigestUtils.sha256Hex(user.getPassword()+salt).equals(password);
    }

    @Override
    public boolean Register(User user) {
        String account = user.getAccount();
        User user1= uerDao.selectOne(new QueryWrapper<User>().
                eq("account",account));
        if(user1 != null)
            return false;

        user.setPassword(DigestUtils.
                sha256Hex(user.getPassword()+user.getSalt()));
        uerDao.insertAll(user);
        return true;
    }

    @Override
    public boolean DeletedUser(String account) {
         int flag = uerDao.delete(new QueryWrapper<User>().eq("account",account));
         return (flag != 0 ? true : false);

    }
}
