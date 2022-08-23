package com.gxu.yueread.controller;


import com.gxu.yueread.common.ResultEnum;
import com.gxu.yueread.controller.param.AdminParam;
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
public class AdminUserController {
    @Resource
    private AdminService adminService;



    //登录
    @RequestMapping("/login")
    public Result login(@RequestBody AdminParam adminParam) {
        Admin loginAdmin = adminService.login(adminParam.getAdminUsername(), adminParam.getAdminPassword());
        if (loginAdmin != null) {
            if (loginAdmin.getAdminPassword().equals(adminParam.getAdminPassword())) {
                Result result = ResultGenerator.genSuccessResult(ResultEnum.LOGIN_SUCCESS.getResult());
                result.setData(loginAdmin);
                return result;
            }
            return ResultGenerator.genFailResult(ResultEnum.PASSWORD_ERROR.getResult());
        }
        return ResultGenerator.genFailResult(ResultEnum.USERNAME_NOT_EXIST.getResult());
    }


    //注册
    @RequestMapping("/register")
    public Result register(@RequestBody AdminParam adminParam) {
        String registerResult = adminService.register(new Admin(adminParam.getAdminUsername(), adminParam.getAdminPassword(), adminParam.getAdminNickname()));
        if (registerResult.equals(ResultEnum.REGISTER_SUCCESS.getResult())) {
            return ResultGenerator.genSuccessResult(registerResult);
        }
        return ResultGenerator.genFailResult(registerResult);
    }


    //更新信息
    @RequestMapping("/update")
    public Result update(@RequestBody AdminParam adminParam) {
        String updateResult = adminService.update(new Admin(adminParam.getAdminId(), adminParam.getAdminUsername(), adminParam.getAdminPassword(), adminParam.getAdminNickname()));
        if (updateResult.equals(ResultEnum.UPDATE_SUCCESS.getResult())) {
            return ResultGenerator.genSuccessResult(updateResult);
        }
        return ResultGenerator.genFailResult(updateResult);
    }

}
