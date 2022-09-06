package com.gxu.yueread.controller;

import com.gxu.yueread.common.ResultEnum;
import com.gxu.yueread.entity.User;
import com.gxu.yueread.service.UserService;
import com.gxu.yueread.util.Result;
import com.gxu.yueread.util.ResultGenerator;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    //登录
    @RequestMapping("/login")
    public Result userLogin(@RequestBody User user) {
        User loginUser =  userService.login(user.getUserUsername());
        if (loginUser != null) {
            if (user.getUserPassword().equals(loginUser.getUserPassword())) {
                Result result =  ResultGenerator.genSuccessResult(loginUser);
                result.setMessage(ResultEnum.LOGIN_SUCCESS.getResult());
                return result;
            }
            return ResultGenerator.genFailResult(ResultEnum.PASSWORD_ERROR.getResult());
        }
        return ResultGenerator.genFailResult(ResultEnum.USERNAME_NOT_EXIST.getResult());
    }


    //注册
    @RequestMapping("/register")
    public Result userRegister(@RequestBody User user) {
        String userRegisterResult = userService.register(user);
        if (userRegisterResult.equals(ResultEnum.REGISTER_SUCCESS.getResult())) {
            return ResultGenerator.genSuccessResult(userRegisterResult);
        }
        return ResultGenerator.genFailResult(userRegisterResult);
    }

    //更新
    @RequestMapping("/update")
    public Result userUpdate(@RequestBody User user) {
        String userRegisterResult = userService.update(user);
        if (userRegisterResult.equals(ResultEnum.UPDATE_SUCCESS.getResult())) {
            return ResultGenerator.genSuccessResult(userRegisterResult);
        }
        return ResultGenerator.genFailResult(userRegisterResult);
    }

    @RequestMapping("/list")
    public Result userList() {
        List<User> userList = userService.userList();
        return ResultGenerator.genSuccessResult(userList);
    }
}
