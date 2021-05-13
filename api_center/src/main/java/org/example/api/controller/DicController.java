package org.example.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.Constant;
import org.example.dto.dic.DicDo;
import org.example.dto.dic.DicQuery;
import org.example.dto.dic.DicVo;
import org.example.service.dic.DicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dic")
@Api(value = "字典基础接口", tags = {"字典模块"})
public class DicController {

    @Autowired
    DicService dicService;

    @GetMapping()
    @ApiOperation(value = "获取字典", notes = "根据主键获取字典", httpMethod = "GET")
    public DicVo get(@RequestParam("id") String id) {
        return dicService.get(id);
    }

    @GetMapping("/query")
    @ApiOperation(value = "查询字典", notes = "根据参数查询字典列表", httpMethod = "GET")
    public List<DicVo> get(@RequestBody DicQuery query, Integer page, Integer size) {
        return dicService.getOfPage(query, page, size);
    }

    @PostMapping
    @ApiOperation(value = "新增字典", notes = "新增字典", httpMethod = "POST")
    public void add(@RequestBody @Validated DicDo dic) {
        dicService.add(dic);
    }

    @PutMapping
    @ApiOperation(value = "更新字典", notes = "更新字典", httpMethod = "PUT")
    public void modify(@RequestBody @Validated DicDo dic) {
        dicService.update(dic);
    }

    @DeleteMapping
    @ApiOperation(value = "删除字典", notes = "软删除字典", httpMethod = "DELETE")
    public void delete(@RequestParam("id") String id) {
        dicService.delete(id, Constant.DELETE_TYPE.SOFT_0);
    }

}
