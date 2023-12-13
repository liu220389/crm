package com.ttc.crms.controller;


import com.ttc.crms.entity.CommonResult;
import com.ttc.crms.service.IDeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/dept")
@Slf4j

public class DeptController {
    @Autowired
    IDeptService deptService;


    @GetMapping("/q/find/all")
    public CommonResult findAll() {
        return deptService.findAll();
    }
}
