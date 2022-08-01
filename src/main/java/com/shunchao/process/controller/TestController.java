package com.shunchao.process.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shunchao.process.entity.Test;
import com.shunchao.process.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RestControllerAdvice
@RequestMapping("/test")
public class TestController {


    @Resource
    private TestService testService;


//    @PostMapping("/getUserByCondition")
//    public ApiResponse getUserByCondition(@RequestBody String jsonStr) {
//        JSONObject object = JSON.parseObject(jsonStr);
//        String param = object.getString("param");
//        SysUser user = sysUserService.getByPhoneOrOpenId(param);
//        return ApiResponse.ok(user);
//    }


    @ResponseBody
    @PostMapping("/list")
    public Object list(@RequestBody String jsonStr) {
        JSONObject object = JSON.parseObject(jsonStr);
        Page page = testService.selectPage(object);
        return page;
    }


    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "hello111";
    }







}
