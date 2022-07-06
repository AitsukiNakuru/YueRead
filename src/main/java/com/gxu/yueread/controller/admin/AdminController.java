package com.gxu.yueread.controller.admin;

import com.gxu.yueread.common.Constants;
import com.gxu.yueread.config.annotation.TokenToAdminUser;
import com.gxu.yueread.controller.admin.param.AdminLoginParam;
import com.gxu.yueread.entity.Admin;
import com.gxu.yueread.entity.AdminToken;
import com.gxu.yueread.service.admin.AdminService;
import com.gxu.yueread.util.Result;
import com.gxu.yueread.util.ResultGenerator;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.Resource;

/**
 * (admin)表控制层
 *
 * @author xxxxx
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    /**
     * 服务对象
     */
    @Resource
    private AdminService adminService;

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public Admin selectOne(Integer id) {
        return adminService.selectByPrimaryKey(id);
    }

    //管理员登录
    @RequestMapping("/login")
    public Result<String> login(@RequestBody AdminLoginParam adminLoginParam) {
        String loginResult = adminService.login(adminLoginParam.getUsername(), adminLoginParam.getPasswordMD5());
        //loginResult的值为token
        logger.info("/admin/login,adminName={},loginResult={}", adminLoginParam.getUsername(), loginResult);
        //成功返回包含token的result
        if (!StringUtils.isEmpty(loginResult) && loginResult.length() == Constants.TOKEN_LENGTH) {
            Result result = ResultGenerator.genSuccessResult();
            result.setData(loginResult);
            return result;
        }
        //失败返回包含失败信息的result
        return ResultGenerator.genFailResult(loginResult);
    }

    @RequestMapping(value = "/logout")
    public Result logout(@RequestBody AdminToken adminToken) {
        logger.info("adminUser:{}", adminToken.toString());
        adminService.logout(adminToken.getAdminId());
        return ResultGenerator.genSuccessResult();
    }

}
