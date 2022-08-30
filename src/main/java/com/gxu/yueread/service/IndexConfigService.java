package com.gxu.yueread.service;

import com.gxu.yueread.common.ResultEnum;
import com.gxu.yueread.controller.param.IndexConfigParam;
import com.gxu.yueread.entity.BookInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.gxu.yueread.entity.IndexConfig;
import com.gxu.yueread.dao.IndexConfigMapper;

import java.util.List;

@Service
public class IndexConfigService {

    @Resource
    private IndexConfigMapper indexConfigMapper;

    @Resource BookInfoService bookInfoService;


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

    public String indexConfigAdd(IndexConfig indexConfig) {

        if (indexConfigMapper.selectByBookId(indexConfig.getBookId()) != null) {
            return ResultEnum.INDEX_BOOK_EXIST.getResult();
        }
        if (indexConfigMapper.insertSelective(indexConfig) >= 0) {
            return ResultEnum.INDEX_BOOK_ADD_SUCCESS.getResult();
        }
        return ResultEnum.INDEX_BOOK_ADD_ERROR.getResult();
    }

    public String indexConfigDelete(IndexConfig indexConfig) {
        if (indexConfigMapper.selectByPrimaryKey(indexConfig.getConfigId()) == null) {
            return ResultEnum.INDEX_BOOK_NOT_EXIST.getResult();
        }
        if (indexConfigMapper.deleteByPrimaryKey(indexConfig.getConfigId()) >= 0) {
            return ResultEnum.INDEX_BOOK_DELETE_SUCCESS.getResult();
        }
        return ResultEnum.INDEX_BOOK_DELETE_ERROR.getResult();
    }

    public String indexConfigUpdate(IndexConfig indexConfig) {
        if (indexConfigMapper.selectByPrimaryKey(indexConfig.getConfigId()) == null) {
            return ResultEnum.INDEX_BOOK_NOT_EXIST.getResult();
        }
        if (indexConfigMapper.updateByPrimaryKeySelective(indexConfig) >= 0) {
            return ResultEnum.INDEX_BOOK_UPDATE_SUCCESS.getResult();
        }
        return ResultEnum.INDEX_BOOK_UPDATE_ERROR.getResult();
    }

    public List<BookInfo> indexBookList() {
        return indexConfigMapper.indexBookList();
    }
}

