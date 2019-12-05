package com.july.util;

import java.util.UUID;

/**
 * UUID生成类
 * @author zqk
 * @since 2019/12/4
 */
public class UuidUtil {

    /**
     * description: 获取UUid前13位
     * @return java.lang.String
     * @author WangWei
     * @date 2019/7/23 9:21
     */
    public static String getUuid(){
        return UUID.randomUUID().toString().toUpperCase().substring(0,12);
    }


    public static String getReplaceUuid() {
        return UUID.randomUUID().toString().toUpperCase().replace("-","");
    }

    public static String getSaltUuid() {
        return UUID.randomUUID().toString().replace("-","");
    }

}
