package com.ttc.crms.service;


import com.ttc.crms.entity.CommonResult;
import com.ttc.crms.entity.Dept;

import java.util.List;

public interface IDeptService {
     CommonResult findAll();
     CommonResult addNew(Dept dept);
     CommonResult modOne(Dept dept);
     CommonResult findByDnameLike( String dname);

}
