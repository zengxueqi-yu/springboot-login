package com.july.intercepts;

import org.springframework.stereotype.Service;

/**
 * Bearer Token解析
 * @author zqk
 * @since 2019/12/4
 */
@Service
public class BearerToken {

    /**
     * @description 获取Bearer后面的加密数据
     * @param token
     * @return
     * @author zqk
     * @since 2019/12/4
    */
    public String getBearerToken(String token) throws Exception {
        if(!token.startsWith("Bearer")){
            throw new Exception("无效token");
        }
        return token.replace("Bearer","").trim();
    }

}
