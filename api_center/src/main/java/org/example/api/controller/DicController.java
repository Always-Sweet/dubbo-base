package org.example.api.controller;

import org.example.Constant;
import org.example.service.dic.DicService;
import org.example.model.Dic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dic")
public class DicController {

    @Autowired
    DicService dicService;

    @GetMapping()
    public Dic get(@RequestParam("id") String id) {
        return dicService.get(id);
    }

    @PostMapping
    public void add(@RequestBody @Validated Dic dic) {
        dicService.add(dic);
    }

    @PutMapping
    public void modify(@RequestBody @Validated Dic dic) {
        dicService.update(dic);
    }

    @DeleteMapping
    public void delete(@RequestBody String id) {
        dicService.delete(id, Constant.DELETE_TYPE.SOFT_0);
    }

}
