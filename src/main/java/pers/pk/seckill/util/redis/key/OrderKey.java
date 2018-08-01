package pers.pk.seckill.util.redis.key;

/**
 * @author panke
 * @date created in 18-8-1 下午12:39
 */
public class OrderKey extends BasePrefix {

    public OrderKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }
}
