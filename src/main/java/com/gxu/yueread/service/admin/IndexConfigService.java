package com.gxu.yueread.service.admin;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.gxu.yueread.dao.admin.IndexConfigMapper;
import com.gxu.yueread.entity.IndexConfig;
@Service
public class IndexConfigService{

    @Resource
    private IndexConfigMapper indexConfigMapper;

    
    public int deleteByPrimaryKey(Integer configId) {
        return indexConfigMapper.deleteByPrimaryKey(configId);
    }

    
    public int insert(IndexConfig record) {
        return indexConfigMapper.insert(record);
    }

    
    public int insertSelective(IndexConfig record) {
        return indexConfigMapper.insertSelective(record);
    }

    
    public IndexConfig selectByPrimaryKey(Integer configId) {
        return indexConfigMapper.selectByPrimaryKey(configId);
    }

    
    public int updateByPrimaryKeySelective(IndexConfig record) {
        return indexConfigMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(IndexConfig record) {
        return indexConfigMapper.updateByPrimaryKey(record);
    }

}
