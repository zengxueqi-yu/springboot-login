package com.july.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.MessageFormat;
import java.util.Objects;
import java.util.Properties;

/**
 * 自定义异常类
 * @author zqk
 * @since 2019/12/4
 */
public class OwnException extends RuntimeException {
    private static final long serialVersionUID = -1494138156106032736L;
    private static final Properties prop = new Properties();
    public static final Integer ERR_CODE = 99999;
    public static final String ERR_MESG = "业务错误";
    public static final Integer NONNULL = 10000;
    public static final Integer NONBLANK = 10001;
    private Integer code;

    public OwnException() {
        this.code = ERR_CODE;
    }

    public OwnException(Integer code, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = ERR_CODE;
        this.code = code;
    }

    public OwnException(String message, Throwable cause) {
        super(message, cause);
        this.code = ERR_CODE;
    }

    public OwnException(Throwable cause) {
        super(cause);
        this.code = ERR_CODE;
    }

    public OwnException(Integer code, String message) {
        super(message);
        this.code = ERR_CODE;
        this.code = code;
    }

    public OwnException(Integer code) {
        this(code, "业务错误");
    }

    public OwnException(String message) {
        this(ERR_CODE, message);
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        String msg = super.getMessage();
        if (msg != null && !"null".equals(msg) && msg.trim().length() > 0) {
            return msg;
        } else {
            try {
                StringWriter sw = new StringWriter();
                Throwable var3 = null;

                Object var6;
                try {
                    PrintWriter pw = new PrintWriter(sw);
                    Throwable var5 = null;

                    try {
                        this.printStackTrace(pw);
                        var6 = sw.toString();
                    } catch (Throwable var31) {
                        var6 = var31;
                        var5 = var31;
                        throw var31;
                    } finally {
                        if (pw != null) {
                            if (var5 != null) {
                                try {
                                    pw.close();
                                } catch (Throwable var30) {
                                    var5.addSuppressed(var30);
                                }
                            } else {
                                pw.close();
                            }
                        }

                    }
                } catch (Throwable var33) {
                    var3 = var33;
                    throw var33;
                } finally {
                    if (sw != null) {
                        if (var3 != null) {
                            try {
                                sw.close();
                            } catch (Throwable var29) {
                                var3.addSuppressed(var29);
                            }
                        } else {
                            sw.close();
                        }
                    }

                }

                return (String)var6;
            } catch (Exception var35) {
                return var35.getMessage();
            }
        }
    }

    @Override
    public String getMessage() {
        return this.message();
    }

    private static OwnException on(Integer code, String message, Object... args) {
        if (code == null) {
            return new OwnException("on(code/message/args)中code不允许为空");
        } else if (message == null) {
            return new OwnException("on(code/message/args)中message不允许为空");
        } else {
            return args == null ? new OwnException("on(code/message/args)中args不允许为空") : new OwnException(code, MessageFormat.format(message, args));
        }
    }

    private static void of(boolean checked, Integer code, String message, Object... args) {
        if (checked) {
            throw on(code, message, args);
        }
    }

    public static void of(boolean checked, Integer code, Object... args) {
        String msg = prop.getProperty(String.valueOf(code), "业务错误");
        of(checked, code, msg, args);
    }

    public static void of(boolean checked, String message, Object... args) {
        of(checked, ERR_CODE, message, args);
    }

    public static void of(String message, Object... args) {
        of(true, ERR_CODE, message, args);
    }

    public static void of(Integer code, Object... args) {
        String msg = prop.getProperty(String.valueOf(code), "业务错误");
        of(true, code, msg, args);
    }

    public static OwnException on(Integer code, Object... args) {
        String msg = prop.getProperty(String.valueOf(code), "业务错误");
        return on(code, msg, args);
    }

    public static OwnException on(String message, Object... args) {
        return on(ERR_CODE, message, args);
    }

    public static <T> void ofNull(T nullChecked, Object... args) {
        String msg = prop.getProperty(String.valueOf(NONNULL), "业务错误");
        of(Objects.isNull(nullChecked), NONNULL, msg, args);
    }

    public static <T> void ofBlank(T blankChecked, Object... args) {
        String msg = prop.getProperty(String.valueOf(NONBLANK), "业务错误");
        of(Objects.isNull(blankChecked) || blankChecked.toString().trim().length() == 0, NONBLANK, msg, args);
    }

    @Override
    public String toString() {
        return "[code=" + this.code() + ", message=" + this.message() + "]";
    }

    static {
        try {
            prop.load(OwnException.class.getResourceAsStream("/errors.properties"));
        } catch (Exception var1) {
            var1.printStackTrace();
        }

    }
}