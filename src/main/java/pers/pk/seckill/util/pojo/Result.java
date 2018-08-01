package pers.pk.seckill.util.pojo;

/**
 * @author panke
 * @date created in 18-7-31 下午6:35
 */
public class Result<Data> {

    private Integer code;
    private String message;
    private Data data;

    private Result(Error error) {
        this.code = error.getCode();
        this.message = error.getMessage();
        this.data = null;
    }

    private Result(Success success) {
        this.code = 200;
        this.message = success.getMessage();
        this.data = null;
    }

    private Result(Success success, Data data) {
        this.code = 200;
        this.message = success.getMessage();
        this.data = data;
    }

    public static <Data> Result<Data> success(Success success, Data data) {
        if (data == null) {
            return new Result<>(success);
        }
        return new Result<>(success, data);
    }

    public static <Data> Result<Data> error(Error error) {
        return new Result<>(error);
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Data getData() {
        return data;
    }
}
