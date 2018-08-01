package pers.pk.seckill.util.pojo;

/**
 * @author panke
 * @date created in 18-7-31 下午6:47
 */
public class Error {

    private Integer code;
    private String message;

    public static Error SERVER_ERROR = new Error(500000, "server error");
    public static Error LOGIN_ERROR = new Error(500100, "Username or password is incorrect");

    private Error(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Error addArg(String arg) {
        String msg = String.format(message, arg);
        return new Error(code, msg);
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
