package org.example.api.controller;

import org.example.service.dic.DicService;
import org.example.model.Dic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dic")
public class DicController {

    @Autowired
    DicService dicService;

    @GetMapping()
    public Dic get(@RequestParam("id") String id) {
        return dicService.get(id);
    }

}
