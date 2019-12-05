package com.july.service;

import com.july.dto.UserLoginDto;
import com.july.dto.UserRedisDto;
import com.july.entity.Userinfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 服务类
 * @author zqk
 * @since 2019/12/4
 */
public interface UserinfoService extends IService<Userinfo> {

    /**
     * @description 登录用户信息获取
     * @param userLoginDto
     * @return
     * @author zqk
     * @since 2019/12/4
     */
    UserRedisDto userInfoLogin(UserLoginDto userLoginDto);

    /**
     * @description 注册用户信息
     * @param userinfo
     * @return
     * @author zqk
     * @since 2019/12/4
     */
    void saveUser(Userinfo userinfo);

}
