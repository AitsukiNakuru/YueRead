package com.gxu.yueread.service;

import com.gxu.yueread.common.ResultEnum;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.gxu.yueread.entity.Admin;
import com.gxu.yueread.dao.AdminMapper;

@Service
public class AdminService {

    @Resource
    private AdminMapper adminMapper;


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

    public Admin login(String username, String password) {
        return adminMapper.login(username);
    }


    public String update(Admin admin) {
        Admin targetAdmin = adminMapper.selectByAdminUsername(admin.getAdminUsername());
        if (targetAdmin != null && !targetAdmin.getAdminId().equals(admin.getAdminId())) {
            return ResultEnum.SAME_USERNAME_EXIST.getResult();
        }
        if (adminMapper.updateByPrimaryKeySelective(admin) >= 1) {
            return ResultEnum.UPDATE_SUCCESS.getResult();
        }
        return ResultEnum.UPDATE_ERROR.getResult();
    }

    public String register(Admin admin) {
        if (adminMapper.selectByAdminUsername(admin.getAdminUsername()) != null) {
            return ResultEnum.SAME_USERNAME_EXIST.getResult();
        }
        if (adminMapper.insertSelective(admin) >= 1) {
            return ResultEnum.REGISTER_SUCCESS.getResult();
        }
        return ResultEnum.REGISTER_ERROR.getResult();
    }
}

