package pers.pk.seckill.util.pojo;

/**
 * @author panke
 * @date created in 18-8-1 下午4:02
 */
public class Success {

    private String message;

    public static Success LOGIN_SUCCESS = new Success("Login success");

    private Success(String message) {
        this.message = message;
    }

    public Success addArg(String arg) {
        String msg = String.format(message, arg);
        return new Success(msg);
    }

    public String getMessage() {
        return message;
    }
}
