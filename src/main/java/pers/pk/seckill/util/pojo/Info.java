package pers.pk.seckill.util.pojo;

/**
 * @author panke
 * @date created in 18-8-1 下午1:11
 */
public enum Info {

    /**
     * redis set successfully
     */
    REDIS_SET_OK("OK"),

    COOKIE_TOKEN("token");

    private String info;

    Info(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
