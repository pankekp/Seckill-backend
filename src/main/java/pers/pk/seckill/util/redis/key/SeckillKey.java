package pers.pk.seckill.util.redis.key;

/**
 * @author panke
 * @date created in 8/6/18 4:53 PM
 */
public class SeckillKey extends BasePrefix {

    public SeckillKey(String prefix) {
        super(prefix);
    }

    public static SeckillKey IS_GOOD_OVER = new SeckillKey("isGoodOver");
}
