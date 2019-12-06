package com.july.annotation;

import java.lang.annotation.*;

/**
 * 系统日志注解
 * @author zqk
 * @since 2019/12/5
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

    String value() default "";

}
