package com.gxu.yueread.service.admin;

import com.gxu.yueread.common.ServiceResultEnum;
import com.gxu.yueread.dao.admin.AdminTokenMapper;
import com.gxu.yueread.entity.AdminToken;
import com.gxu.yueread.util.MD5Util;
import com.gxu.yueread.util.NumberUtil;
import com.gxu.yueread.util.Result;
import com.gxu.yueread.util.SystemUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.gxu.yueread.entity.Admin;
import com.gxu.yueread.dao.admin.AdminMapper;

import java.util.Date;

@Service
public class AdminService {

    @Resource
    private AdminMapper adminMapper;
    @Resource
    private AdminTokenMapper adminTokenMapper;

    public int deleteByPrimaryKey(Integer adminId) {
        return adminMapper.deleteByPrimaryKey(adminId);
    }


    public int insert(Admin record) {
        return adminMapper.insert(record);
    }


    public int insertSelective(Admin record) {
        return adminMapper.insertSelective(record);
    }


    public Admin selectByPrimaryKey(Integer adminId) {
        return adminMapper.selectByPrimaryKey(adminId);
    }


    public int updateByPrimaryKeySelective(Admin record) {
        return adminMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(Admin record) {
        return adminMapper.updateByPrimaryKey(record);
    }

    public String login(String username, String password) {
        Admin admin = adminMapper.login(username, password);
        if (admin != null) {
            String token = getNewToken(System.currentTimeMillis() + "", admin.getAdminId());
            AdminToken adminToken = adminTokenMapper.selectByPrimaryKey(admin.getAdminId());

            Date now = new Date();
            Date expireTime = new Date(now.getTime() + 2 * 24 * 3600 * 1000);

            if (adminToken == null) {
                adminToken = new AdminToken(admin.getAdminId(), token, now, expireTime);

                if (adminTokenMapper.insertSelective(adminToken) > 0) {
                    return token;
                }
            } else {
                adminToken.setAdminToken(token);
                adminToken.setCreateTime(now);
                adminToken.setExpireTime(expireTime);

                if (adminTokenMapper.updateByPrimaryKeySelective(adminToken) > 0) {
                    return token;
                }
            }
        }
        return ServiceResultEnum.LOGIN_ERROR.getResult();
    }


    public String getNewToken(String timeStr, Integer adminId) {
        String src = timeStr + adminId + NumberUtil.genRandomNum(6);
        return SystemUtil.genToken(src);
    }



    public Boolean logout(Integer adminId) {
        return adminTokenMapper.deleteByPrimaryKey(adminId) > 0;
    }

    public String register(String adminUsername, String adminPassword, String adminNickname) {
        MD5Util md5Util = new MD5Util();
        Admin admin = new Admin(adminUsername, md5Util.MD5Encode(adminPassword), adminNickname);
        if (this.insertSelective(admin) > 0) {
            return "success";
        }
        return ServiceResultEnum.REGISTER_ERROR.getResult();
    }
}