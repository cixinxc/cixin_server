package com.cn.cixin.user.service;


import com.cn.cixin.user.model.User;

/**
 * Created by cixinxc on 2017/6/11.
 */
public interface IUserService {
    //根据userId获得User实体
    public User getUserById(String userId);
    /**
     * 根据userName获得User实体
     */
    public User getUserByUserName(String userName);
    //根据userName、password、userType判断是否账号
    public boolean loginCheck(String userName, String password);
    //注册user
    public int insert(User user);

}