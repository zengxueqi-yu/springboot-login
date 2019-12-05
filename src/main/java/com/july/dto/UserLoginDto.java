package com.july.dto;

import lombok.Data;

/**
 * 用户登录参数
 * @author zqk
 * @since 2019/12/4
 */
@Data
public class UserLoginDto {

    private String mobile;
    private String password;
    private String token;

}
