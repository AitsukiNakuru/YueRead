package com.gxu.yueread.service.admin;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.gxu.yueread.entity.AdminToken;
import com.gxu.yueread.dao.admin.AdminTokenMapper;
@Service
public class AdminTokenService{

    @Resource
    private AdminTokenMapper adminTokenMapper;

    
    public int deleteByPrimaryKey(Integer adminId) {
        return adminTokenMapper.deleteByPrimaryKey(adminId);
    }

    
    public int insert(AdminToken record) {
        return adminTokenMapper.insert(record);
    }

    
    public int insertSelective(AdminToken record) {
        return adminTokenMapper.insertSelective(record);
    }

    
    public AdminToken selectByPrimaryKey(Integer adminId) {
        return adminTokenMapper.selectByPrimaryKey(adminId);
    }

    
    public int updateByPrimaryKeySelective(AdminToken record) {
        return adminTokenMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(AdminToken record) {
        return adminTokenMapper.updateByPrimaryKey(record);
    }

}
