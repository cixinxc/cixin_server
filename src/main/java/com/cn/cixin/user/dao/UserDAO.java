package com.cn.cixin.user.dao;


import com.cn.cixin.user.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserDAO {
    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    boolean loginCheck(@Param("userName")String userName, @Param("password")String password);
}