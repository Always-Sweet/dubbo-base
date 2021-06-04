package org.example.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.ResultBuilder;
import org.example.dto.Result;
import org.example.dto.dic.DicDeleteParams;
import org.example.dto.dic.DicDo;
import org.example.dto.dic.DicQuery;
import org.example.exception.LogicError;
import org.example.service.dic.DicService;
import org.example.valid.dic.DicSaveCheck;
import org.example.valid.dic.DicUpdateCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author 章春波
 * @date 2021/6/1 15:49
 * @ClassName: DicController
 * @Description: 字典基础接口
 */
@RestController
@RequestMapping("/dic")
@Api(value = "字典基础接口", tags = {"字典模块"})
public class DicController {

    @Autowired
    DicService dicService;

    @GetMapping()
    @ApiOperation(value = "获取字典", notes = "根据主键获取字典", httpMethod = "GET")
    public Result get(@RequestParam("id") String id) throws LogicError {
        return ResultBuilder.successWithData(dicService.get(id));
    }


    @GetMapping("/query")
    @ApiOperation(value = "查询字典", notes = "根据参数查询字典列表", httpMethod = "GET")
    public Result get(@RequestBody @Validated DicQuery query) {
        return ResultBuilder.successWithData(dicService.getOfPage(query));
    }

    @PostMapping
    @ApiOperation(value = "新增字典", notes = "新增字典", httpMethod = "POST")
    public Result add(@RequestBody @Validated({DicSaveCheck.class}) DicDo dic) {
        return ResultBuilder.successWithData(dicService.add(dic));
    }

    @PutMapping
    @ApiOperation(value = "更新字典", notes = "更新字典", httpMethod = "PUT")
    public Result modify(@RequestBody @Validated({DicUpdateCheck.class}) DicDo dic) {
        dicService.update(dic);
        return ResultBuilder.successWithoutData();
    }

    @DeleteMapping
    @ApiOperation(value = "删除字典", notes = "多选删除及删除形式（注销/数据沉默）", httpMethod = "DELETE")
    public Result delete(@RequestBody @Validated DicDeleteParams dicDeleteParams) {
        dicService.batchDelete(dicDeleteParams.getIds(), dicDeleteParams.getDeleteType());
        return ResultBuilder.successWithoutData();
    }

}
