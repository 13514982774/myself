package com.shunchao.process.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shunchao.process.entity.Test;
import com.shunchao.process.mapper.TestMapper;
import com.shunchao.process.service.TestService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements TestService {

    @Override
    public Page selectPage(JSONObject params) {
        // 参数设置
        LambdaQueryWrapper<Test> wrapper = new LambdaQueryWrapper<>();
        // 模糊查询条件
        if (params.containsKey("val") && StringUtils.isNotBlank(params.getString("val"))) {
            wrapper.like(Test::getVal, params.get("val"));
        }
        // 当前页
        int pageNumber = params.getIntValue("page");
        // 每页条数
        int pageSize = params.getIntValue("size");
        // 创建一个Page对象
        Page page = new Page(pageNumber, pageSize);
        page = baseMapper.selectPage(page, wrapper);
        page.setTotal(page.getRecords().size());
        return page;
    }



}
