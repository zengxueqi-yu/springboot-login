package com.july.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户信息
 * @author zqk
 * @since 2019/12/4
 */
@Data
public class UserRedisDto implements Serializable {

    private static final long serialVersionUID = 5023117841383888178L;

    private Long id;
    private String username;
    private String mobile;
    private String token;

}
