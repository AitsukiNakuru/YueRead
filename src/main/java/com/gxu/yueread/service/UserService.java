package com.gxu.yueread.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.gxu.yueread.dao.UserMapper;
import com.gxu.yueread.entity.User;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;


    public int deleteByPrimaryKey(Integer userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }


    public int insert(User record) {
        return userMapper.insert(record);
    }


    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }


    public User selectByPrimaryKey(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }


    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

}

