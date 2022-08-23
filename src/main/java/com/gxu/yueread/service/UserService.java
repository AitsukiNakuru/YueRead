package com.gxu.yueread.service;

import com.gxu.yueread.common.ResultEnum;
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

    public User login(String username, String password) {
        return userMapper.selectByUsername(username);

    }

    public String register(User user) {
        if (userMapper.selectByUsername(user.getUserUsername()) != null) {
            return ResultEnum.SAME_USERNAME_EXIST.getResult();
        }
        if (userMapper.insertSelective(user) >= 1) {
            return ResultEnum.REGISTER_SUCCESS.getResult();
        }
        return ResultEnum.REGISTER_ERROR.getResult();
    }


    public String update(User user) {
        User targetUser = userMapper.selectByUsername(user.getUserUsername());
        if (targetUser != null && targetUser.getUserId().equals(user.getUserId())) {
            return  ResultEnum.SAME_USERNAME_EXIST.getResult();
        }
        if (userMapper.updateByPrimaryKey(user) >= 1) {
            return ResultEnum.UPDATE_SUCCESS.getResult();
        }
        return ResultEnum.UPDATE_ERROR.getResult();
    }
}

