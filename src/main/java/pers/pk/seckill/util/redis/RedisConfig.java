package pers.pk.seckill.util.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author panke
 * @date created in 18-7-31 下午8:43
 */

@Configuration
public class RedisConfig {

    private RedisConfigMap redisConfigMap;

    @Autowired
    public RedisConfig(RedisConfigMap redisConfigMap) {
        this.redisConfigMap = redisConfigMap;
    }

    @Bean
    public JedisPool jedisPoolFactory() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(redisConfigMap.getPoolMaxTotal());
        jedisPoolConfig.setMaxIdle(redisConfigMap.getPoolMaxIdle());
        jedisPoolConfig.setMaxWaitMillis(redisConfigMap.getPoolMaxWait() * 1000);
        return new JedisPool(jedisPoolConfig, redisConfigMap.getHost(), redisConfigMap.getPort(),
                redisConfigMap.getTimeout(), redisConfigMap.getPassword(), 0);
    }
}
