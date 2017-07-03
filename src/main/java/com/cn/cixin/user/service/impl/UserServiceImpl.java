package com.cn.cixin.user.service.impl;


import com.cn.cixin.user.dao.UserDAO;
import com.cn.cixin.user.model.User;
import com.cn.cixin.user.service.IUserService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * Created by cixinxc on 2017/6/11.
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
    @Resource
    private UserDAO userDao;

    public User getUserById(String userId) {
        // TODO Auto-generated method stub
        return this.userDao.selectByPrimaryKey(userId);
    }

    public User getUserByUserName(String userName) {
        return null;
    }


    public int insert(User user) {
        // TODO Auto-generated method stub
        return this.userDao.insert(user);
    }


    public boolean loginCheck(String userName,String password) {
        // TODO Auto-generated method stub
        return this.userDao.loginCheck(userName,password);
    }
}