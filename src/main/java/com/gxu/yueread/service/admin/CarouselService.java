package com.gxu.yueread.service.admin;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.gxu.yueread.entity.Carousel;
import com.gxu.yueread.dao.admin.CarouselMapper;
@Service
public class CarouselService{

    @Resource
    private CarouselMapper carouselMapper;

    
    public int deleteByPrimaryKey(Integer carouselId) {
        return carouselMapper.deleteByPrimaryKey(carouselId);
    }

    
    public int insert(Carousel record) {
        return carouselMapper.insert(record);
    }

    
    public int insertSelective(Carousel record) {
        return carouselMapper.insertSelective(record);
    }

    
    public Carousel selectByPrimaryKey(Integer carouselId) {
        return carouselMapper.selectByPrimaryKey(carouselId);
    }

    
    public int updateByPrimaryKeySelective(Carousel record) {
        return carouselMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Carousel record) {
        return carouselMapper.updateByPrimaryKey(record);
    }

}
