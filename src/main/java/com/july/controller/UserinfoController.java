package com.july.controller;


import com.july.dto.UserLoginDto;
import com.july.dto.UserRedisDto;
import com.july.entity.Userinfo;
import com.july.service.UserinfoService;
import com.july.util.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 前端控制器
 * @author zqk
 * @since 2019/12/4
 */
@RestController
@RequestMapping("/userinfo")
public class UserinfoController {

    @Resource
    private UserinfoService userinfoService;

    /**
     * @description 用户登录
     * @param userLoginDto
     * @return
     * @author zqk
     * @since 2019/12/4
    */
    @PostMapping("/login")
    public Result login(@RequestBody UserLoginDto userLoginDto){
        return Result.ok(userinfoService.userInfoLogin(userLoginDto));
    }

    /**
     * @description 注册用户信息
     * @param userinfo
     * @return
     * @author zqk
     * @since 2019/12/4
    */
    @PostMapping("/saveUser")
    public Result saveUser(@RequestBody Userinfo userinfo){
        userinfoService.saveUser(userinfo);
        return Result.ok("注册成功");
    }

    /**
     * @description 查询某个用户的信息
     * @param userinfo
     * @return
     * @author zqk
     * @since 2019/12/4
    */
    @PostMapping("/getUser")
    public Result getUser(@RequestBody Userinfo userinfo){
        return Result.ok(userinfoService.getById(userinfo.getId()));
    }

}
