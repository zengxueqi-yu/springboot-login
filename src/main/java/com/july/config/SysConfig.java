package com.july.config;

/**
 * 参数配置类
 * @author zqk
 * @since 2019/12/4
 */
public class SysConfig {

    /**
     * 登录信息
     */
    public interface LoginInfo {
        /**
         * 登录过期时间(分)
         */
        Integer EXPIRE_LOGIN = 8 * 60;
        /**
         * 缓存名称标识
         */
        String CACHE_NAME = "login_";
    }

}
