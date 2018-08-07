package pers.pk.seckill.util.redis.key;

/**
 * @author panke
 * @date created in 8/6/18 3:07 PM
 */
public class GoodKey extends BasePrefix {

    public GoodKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public static GoodKey SECKILL_STOCK = new GoodKey(0, "seckillStock");
}
