package com.gxu.yueread.controller.admin;


import com.gxu.yueread.common.ResultEnum;
import com.gxu.yueread.controller.admin.param.AdminLoginParam;
import com.gxu.yueread.controller.admin.param.AdminRegisterParam;
import com.gxu.yueread.controller.admin.param.AdminUpdateParam;
import com.gxu.yueread.entity.Admin;
import com.gxu.yueread.service.AdminService;
import com.gxu.yueread.util.Result;
import com.gxu.yueread.util.ResultGenerator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin")
public class AdminUserController {
    @Resource
    private AdminService adminService;

    private static final Logger logger = LoggerFactory.getLogger(AdminUserController.class);


    @RequestMapping("/login")
    public Result login(@RequestBody AdminLoginParam adminLoginParam) {
        Admin loginAdmin = adminService.login(adminLoginParam.getAdminUsername(), adminLoginParam.getAdminPassword());
        logger.info("Admin Login,adminUsername={},loginResult={}", adminLoginParam.getAdminUsername(), loginAdmin);
        if (loginAdmin != null) {
            Result result = ResultGenerator.genSuccessResult(ResultEnum.LOGIN_SUCCESS.getResult());
            result.setData(loginAdmin);
            return result;
        }
        return ResultGenerator.genFailResult(ResultEnum.LOGIN_ERROR.getResult());
    }

    @RequestMapping("/register")
    public Result register(@RequestBody AdminRegisterParam adminRegisterParam) {
        String registerResult = adminService.register(new Admin(adminRegisterParam.getAdminUsername(), adminRegisterParam.getAdminPassword(), adminRegisterParam.getAdminNickname()));
        logger.info("Admin Register,adminUsername={},registerResult={}", adminRegisterParam.getAdminUsername(), registerResult);
        if (registerResult.equals(ResultEnum.REGISTER_SUCCESS.getResult())) {
            return ResultGenerator.genSuccessResult(registerResult);
        }
        return ResultGenerator.genFailResult(registerResult);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody AdminUpdateParam adminUpdateParam) {
        String updateResult = adminService.update(new Admin(adminUpdateParam.getAdminUsername(), adminUpdateParam.getAdminPassword(), adminUpdateParam.getAdminNickname()), adminUpdateParam.getOriginalId());
        logger.info("Admin Update,adminUsername={},updateResult={}", adminUpdateParam.getAdminUsername(), updateResult);
        if (updateResult.equals(ResultEnum.UPDATE_SUCCESS.getResult())) {
            return ResultGenerator.genSuccessResult(updateResult);
        }
        return ResultGenerator.genFailResult(updateResult);
    }

}
