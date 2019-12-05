package com.july.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.july.config.SysConfig;
import com.july.dto.UserLoginDto;
import com.july.dto.UserRedisDto;
import com.july.entity.Userinfo;
import com.july.mapper.UserinfoMapper;
import com.july.service.UserinfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.july.util.Md5Util;
import com.july.util.OwnException;
import com.july.util.RedisToolUtils;
import com.july.util.UuidUtil;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 服务实现类
 * @author zqk
 * @since 2019/12/4
 */
@Service
public class UserinfoServiceImpl extends ServiceImpl<UserinfoMapper, Userinfo> implements UserinfoService {

    @Resource
    private RedisToolUtils redisToolUtils;

    /**
     * @description 登录用户信息获取
     * @param userLoginDto
     * @return 
     * @author zqk
     * @since 2019/12/4
    */
    @Override
    public UserRedisDto userInfoLogin(UserLoginDto userLoginDto){
        Userinfo userinfo = getUserByMobile(userLoginDto.getMobile());
        OwnException.of(userinfo == null,"用户不存在");

        //判断用户登录密码是否正确
        String saltPwd = Md5Util.generatePassword(userLoginDto.getPassword(),userinfo.getPwdsalt());
        OwnException.of(!saltPwd.equals(userinfo.getPassword()),"密码输入错误，请确认后重新输入！");

        String token = UuidUtil.getReplaceUuid();
        UserRedisDto userRedisDto = new UserRedisDto();
        BeanUtils.copyProperties(userinfo,userRedisDto);
        userRedisDto.setToken(token);
        redisToolUtils.setRedisContent(SysConfig.LoginInfo.CACHE_NAME + token,userRedisDto.getId(),SysConfig.LoginInfo.EXPIRE_LOGIN, TimeUnit.MINUTES);

        redisToolUtils.setRedisContent(SysConfig.LoginInfo.CACHE_NAME + userRedisDto.getId(),
                JSON.toJSONString(userRedisDto), SysConfig.LoginInfo.EXPIRE_LOGIN, TimeUnit.MINUTES);
        return userRedisDto;
    }

    /**
     * @description 通过手机号获取用户信息
     * @param mobile
     * @return
     * @author zqk
     * @since 2019/12/4
    */
    public Userinfo getUserByMobile(String mobile){
        QueryWrapper<Userinfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(!StringUtils.isEmpty(mobile),"mobile",mobile);
        return this.getOne(queryWrapper);
    }

    /**
     * @description 注册用户信息
     * @param userinfo
     * @return 
     * @author zqk
     * @since 2019/12/4
    */
    @Override
    public void saveUser(Userinfo userinfo){
        Userinfo userinfo1 = this.getUserByMobile(userinfo.getMobile());
        OwnException.of(userinfo1 != null,"该手机好已经注册过，请重新输入手机号！");

        String salt = UUID.randomUUID().toString().replace("-", "");
        String saltPwd = Md5Util.generatePassword(userinfo.getMobile().substring(5), salt);
        userinfo.setPassword(saltPwd);
        userinfo.setPwdsalt(salt);
        this.save(userinfo);
    }

}
