package com.july.util;

import java.util.HashMap;

/**
 * 接口返回信息
 * @author zqk
 * @since 2019/12/4
 */
public class Result extends HashMap<String, Object> {
    private static final long serialVersionUID = -8194821450292902175L;
    private static final Integer SUCCESS = 0;
    private static final Integer FAIL = -1;

    public Result() {
        this("处理成功");
    }

    public Result(String msg) {
        this.put((String)"code", SUCCESS);
        this.put((String)"msg", msg);
    }

    public static Result error(int code, String msg) {
        Result r = new Result();
        r.put((String)"code", code);
        r.put((String)"msg", msg);
        return r;
    }

    public static Result error() {
        return error(FAIL, "未知异常，请联系管理员");
    }

    public static Result error(String msg) {
        return error(FAIL, msg);
    }

    public static Result ok(String msg) {
        Result r = new Result();
        r.put((String)"msg", msg);
        return r;
    }

    public static Result ok(Object data) {
        Result r = new Result();
        r.put("content", data);
        return r;
    }

    public static Result ok() {
        return new Result();
    }

    @Override
    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
