package pers.pk.seckill.util.redis;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pers.pk.seckill.util.redis.key.KeyPrefix;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author panke
 * @date created in 18-7-31 下午8:03
 */

@Component
public class RedisUtil {

    private JedisPool jedisPool;

    @Autowired
    public RedisUtil(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    public <T> T get(KeyPrefix keyPrefix, String key, Class<T> clazz) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String realKey = keyPrefix.getPrefix() + key;
            String str = jedis.get(realKey);
            return strToObj(str, clazz);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    private <T> T strToObj(String str, Class<T> clazz) {
        if (str == null) {
            return null;
        }
        if (clazz == int.class || clazz == Integer.class) {
            return (T) Integer.valueOf(str);
        } else if (clazz == String.class) {
            return (T) str;
        } else {
            return JSON.toJavaObject(JSON.parseObject(str), clazz);
        }
    }

    public <T> String set(KeyPrefix keyPrefix, String key, T value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String str = objToStr(value);
            String realKey = keyPrefix.getPrefix() + key;
            if (keyPrefix.expireSeconds() <= 0) {
                return jedis.set(realKey, str);
            } else {
                return jedis.setex(realKey, keyPrefix.expireSeconds(), str);
            }
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    private <T> String objToStr(T value) {
        if (value == null) {
            return null;
        }
        Class<?> clazz = value.getClass();
        if (clazz == int.class || clazz == Integer.class) {
            return "" + value;
        } else if (clazz == String.class) {
            return (String) value;
        } else {
            return JSON.toJSONString(value);
        }
    }

    public boolean exist(KeyPrefix keyPrefix, String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String realKey = keyPrefix.getPrefix() + key;
            return jedis.exists(realKey);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public Long increase(KeyPrefix keyPrefix, String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String realKey = keyPrefix.getPrefix() + key;
            return jedis.incr(realKey);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public Long decrease(KeyPrefix keyPrefix, String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String realKey = keyPrefix.getPrefix() + key;
            return jedis.decr(realKey);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
}
