package pers.pk.seckill.util.pojo;

/**
 * @author panke
 * @date created in 18-7-31 下午6:47
 */
public class Error {

    private Integer code;
    private String message;

    public static Error LOGIN_ERROR = new Error(500100, "Username or password is incorrect");
    public static Error STOCK_NULL_ERROR = new Error(500201, "The stock is 0 now");
    public static Error SECKILL_REPEATED_ERROR = new Error(500202, "You can't have a repeated seckill");
    public static Error SECKILL_FAILED_ERROR = new Error(500203, "Seckill failed");

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
