package com.gxu.yueread.controller;

import com.gxu.yueread.common.ResultEnum;
import com.gxu.yueread.controller.param.IndexConfigParam;
import com.gxu.yueread.entity.IndexConfig;
import com.gxu.yueread.service.IndexConfigService;
import com.gxu.yueread.util.BeanUtil;
import com.gxu.yueread.util.Result;
import com.gxu.yueread.util.ResultGenerator;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (index_config)表控制层
 *
 * @author xxxxx
 */
@RestController
@RequestMapping("/index")
public class IndexConfigController {
    /**
     * 服务对象
     */
    @Resource
    private IndexConfigService indexConfigService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public IndexConfig selectOne(Integer id) {
        return indexConfigService.selectByPrimaryKey(id);
    }

    @RequestMapping("/add")
    public Result indexConfigAdd(@RequestBody IndexConfigParam indexConfigParam) {
        IndexConfig indexConfig = new IndexConfig();
        BeanUtil.copyProperties(indexConfigParam, indexConfig);
        String indexConfigAddResult =  indexConfigService.indexConfigAdd(indexConfig);
        if (indexConfigAddResult.equals(ResultEnum.INDEX_BOOK_ADD_SUCCESS.getResult())) {
            return ResultGenerator.genSuccessResult(indexConfigAddResult);
        }
        return ResultGenerator.genFailResult(indexConfigAddResult);
    }

    @RequestMapping("/delete")
    public Result indexConfigDelete(@RequestBody IndexConfigParam indexConfigParam) {
        IndexConfig indexConfig = new IndexConfig();
        BeanUtil.copyProperties(indexConfigParam, indexConfig);
        String indexConfigDeleteResult =  indexConfigService.indexConfigDelete(indexConfig);
        if (indexConfigDeleteResult.equals(ResultEnum.INDEX_BOOK_DELETE_SUCCESS.getResult())) {
            return ResultGenerator.genSuccessResult(indexConfigDeleteResult);
        }
        return ResultGenerator.genFailResult(indexConfigDeleteResult);
    }

    @RequestMapping("/update")
    public Result indexConfigUpdate(@RequestBody IndexConfigParam indexConfigParam) {
        IndexConfig indexConfig = new IndexConfig();
        BeanUtil.copyProperties(indexConfigParam, indexConfig);
        String indexConfigUpdateResult =  indexConfigService.indexConfigUpdate(indexConfig);
        if (indexConfigUpdateResult.equals(ResultEnum.INDEX_BOOK_UPDATE_SUCCESS.getResult())) {
            return ResultGenerator.genSuccessResult(indexConfigUpdateResult);
        }
        return ResultGenerator.genFailResult(indexConfigUpdateResult);
    }

    @RequestMapping("/list")
    public Result indexConfigList() {
        List<IndexConfig> indexConfigList = indexConfigService.indexConfigList();
        return ResultGenerator.genSuccessResult(indexConfigList);
    }

}
