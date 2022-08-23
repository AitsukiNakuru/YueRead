package com.gxu.yueread.controller;

import com.gxu.yueread.common.ResultEnum;
import com.gxu.yueread.controller.param.UserParam;
import com.gxu.yueread.entity.User;
import com.gxu.yueread.service.UserService;
import com.gxu.yueread.util.Result;
import com.gxu.yueread.util.ResultGenerator;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    //登录
    @RequestMapping("/login")
    public Result userLogin(@RequestBody UserParam userParam) {
        User user = userService.login(userParam.getUserUsername(), userParam.getUserPassword());
        if (user != null) {
            if (user.getUserPassword().equals(userParam.getUserPassword())) {
                Result result = ResultGenerator.genSuccessResult(ResultEnum.LOGIN_SUCCESS.getResult());
                result.setData(user);
                return result;
            }
            return ResultGenerator.genFailResult(ResultEnum.PASSWORD_ERROR.getResult());
        }
        return ResultGenerator.genFailResult(ResultEnum.USERNAME_NOT_EXIST.getResult());
    }


    //注册
    @RequestMapping("/register")
    public Result userRegister(@RequestBody UserParam userParam) {
        String userRegisterResult = userService.register(new User(userParam.getUserUsername(), userParam.getUserPassword(), userParam.getUserNickname()));
        if (userRegisterResult.equals(ResultEnum.REGISTER_SUCCESS.getResult())) {
            return ResultGenerator.genSuccessResult(userRegisterResult);
        }
        return ResultGenerator.genFailResult(userRegisterResult);
    }

    //更新
    @RequestMapping("/update")
    public Result userUpdate(@RequestBody UserParam userParam) {
        String userRegisterResult = userService.update(new User(userParam.getUserId(), userParam.getUserUsername(), userParam.getUserPassword(), userParam.getUserNickname()));
        if (userRegisterResult.equals(ResultEnum.REGISTER_SUCCESS.getResult())) {
            return ResultGenerator.genSuccessResult(userRegisterResult);
        }
        return ResultGenerator.genFailResult(userRegisterResult);
    }
}
