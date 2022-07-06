package com.gxu.yueread.dao.admin;

import com.gxu.yueread.entity.Carousel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CarouselMapper {
    /**
     * delete by primary key
     *
     * @param carouselId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer carouselId);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(Carousel record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(Carousel record);

    /**
     * select by primary key
     *
     * @param carouselId primary key
     * @return object by primary key
     */
    Carousel selectByPrimaryKey(Integer carouselId);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Carousel record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Carousel record);
}