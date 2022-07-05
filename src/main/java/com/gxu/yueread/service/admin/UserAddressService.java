package com.gxu.yueread.service.admin;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.gxu.yueread.entity.UserAddress;
import com.gxu.yueread.dao.admin.UserAddressMapper;
@Service
public class UserAddressService{

    @Resource
    private UserAddressMapper userAddressMapper;

    
    public int deleteByPrimaryKey(Integer addressId) {
        return userAddressMapper.deleteByPrimaryKey(addressId);
    }

    
    public int insert(UserAddress record) {
        return userAddressMapper.insert(record);
    }

    
    public int insertSelective(UserAddress record) {
        return userAddressMapper.insertSelective(record);
    }

    
    public UserAddress selectByPrimaryKey(Integer addressId) {
        return userAddressMapper.selectByPrimaryKey(addressId);
    }

    
    public int updateByPrimaryKeySelective(UserAddress record) {
        return userAddressMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(UserAddress record) {
        return userAddressMapper.updateByPrimaryKey(record);
    }

}
