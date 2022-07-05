package com.gxu.yueread.service.admin;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.gxu.yueread.entity.Admin;
import com.gxu.yueread.dao.admin.AdminMapper;
@Service
public class AdminService{

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

}
