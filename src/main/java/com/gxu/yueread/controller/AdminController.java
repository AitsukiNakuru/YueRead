package com.gxu.yueread.controller;


import com.gxu.yueread.common.ResultEnum;
import com.gxu.yueread.entity.Admin;
import com.gxu.yueread.service.AdminService;
import com.gxu.yueread.util.Result;
import com.gxu.yueread.util.ResultGenerator;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private AdminService adminService;



    //登录
    @RequestMapping("/login")
    public Result login(@RequestBody Admin admin) {
        Admin loginAdmin = adminService.login(admin.getAdminUsername(), admin.getAdminPassword());
        if (loginAdmin != null) {
            if (loginAdmin.getAdminPassword().equals(admin.getAdminPassword())) {
                Result result = ResultGenerator.genSuccessResult(loginAdmin);
                result.setMessage(ResultEnum.LOGIN_SUCCESS.getResult());
                return result;
            }
            return ResultGenerator.genFailResult(ResultEnum.PASSWORD_ERROR.getResult());
        }
        return ResultGenerator.genFailResult(ResultEnum.USERNAME_NOT_EXIST.getResult());
    }


    //注册
    @RequestMapping("/register")
    public Result register(@RequestBody Admin admin) {
        String registerResult = adminService.register(admin);
        if (registerResult.equals(ResultEnum.REGISTER_SUCCESS.getResult())) {
            return ResultGenerator.genSuccessResult(registerResult);
        }
        return ResultGenerator.genFailResult(registerResult);
    }


    //更新信息
    @RequestMapping("/update")
    public Result update(@RequestBody Admin admin) {
        String updateResult = adminService.update(admin);
        if (updateResult.equals(ResultEnum.UPDATE_SUCCESS.getResult())) {
            return ResultGenerator.genSuccessResult(updateResult);
        }
        return ResultGenerator.genFailResult(updateResult);
    }

}
