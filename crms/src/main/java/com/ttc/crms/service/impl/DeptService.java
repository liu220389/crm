package com.ttc.crms.service.impl;

import com.ttc.crms.entity.CommonResult;
import com.ttc.crms.entity.Dept;
import com.ttc.crms.mapper.DeptMapper;
import com.ttc.crms.service.IDeptService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService implements IDeptService {
    @Autowired
    DeptMapper mapper;

    @Override
    public CommonResult addNew(Dept dept) {

        return null;
    }

    @Override
    public CommonResult modOne(Dept dept) {
        return null;
    }

    @Override
    public CommonResult findByDnameLike(String dname) {
        return null;
    }

    @Override
    public CommonResult findAll() {
        List<Dept> list = mapper.findAll();
        CommonResult  result =  new CommonResult(list);
        return result;
    }
}
