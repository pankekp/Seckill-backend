package pers.pk.seckill.util.redis.key;

/**
 * @author panke
 * @date created in 18-8-1 下午12:39
 */
public class UserKey extends BasePrefix {

    private UserKey(String prefix) {
        super(prefix);
    }

    public static UserKey ID = new UserKey("id");
    public static UserKey NAME = new UserKey("name");
}
