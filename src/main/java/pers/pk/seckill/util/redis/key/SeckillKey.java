package pers.pk.seckill.util.redis.key;

/**
 * @author panke
 * @date created in 8/6/18 4:53 PM
 */
public class SeckillKey extends BasePrefix {

    public SeckillKey(String prefix) {
        super(prefix);
    }

    public SeckillKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public static SeckillKey IS_GOOD_OVER = new SeckillKey("isGoodOver");
    public static SeckillKey ACCESS_LIMIT = new SeckillKey(5, "access");
}
