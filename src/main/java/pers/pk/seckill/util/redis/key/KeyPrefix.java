package pers.pk.seckill.util.redis.key;

/**
 * @author panke
 * @date created in 18-8-1 下午12:36
 */
public interface KeyPrefix {

    public int expireSeconds();

    public String getPrefix();
}
