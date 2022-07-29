package com.shunchao.process.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shunchao.process.entity.Test;

public interface TestService extends IService<Test> {


    Page selectPage(JSONObject object);
}
