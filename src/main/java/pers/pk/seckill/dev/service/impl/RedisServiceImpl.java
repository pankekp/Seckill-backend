package pers.pk.seckill.dev.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.pk.seckill.dev.service.RedisService;
import pers.pk.seckill.domain.SeckillOrderInfo;
import pers.pk.seckill.domain.User;
import pers.pk.seckill.util.redis.RedisUtil;
import pers.pk.seckill.util.redis.key.GoodKey;
import pers.pk.seckill.util.redis.key.OrderKey;
import pers.pk.seckill.util.redis.key.SeckillKey;
import pers.pk.seckill.util.redis.key.UserKey;

/**
 * @author panke
 * @date created in 8/7/18 2:34 PM
 */

@Service
public class RedisServiceImpl implements RedisService {

    private RedisUtil redisUtil;

    @Autowired
    public RedisServiceImpl(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }

    @Override
    public void setUser(User user, String token) {
        redisUtil.set(UserKey.TOKEN, token, user);
    }

    @Override
    public User getUser(String token) {
        return redisUtil.get(UserKey.TOKEN, token, User.class);
    }

    @Override
    public Long decreaseStock(int goodId) {
        return redisUtil.decrease(GoodKey.SECKILL_STOCK, goodId + "");
    }

    @Override
    public void loadStockToCache(int goodId, int stock) {
        redisUtil.set(GoodKey.SECKILL_STOCK, goodId + "", stock);
    }

    @Override
    public void setSeckillOrder(int userId, int goodId, SeckillOrderInfo seckillOrderInfo) {
        redisUtil.set(OrderKey.SECKILL_ORDER, userId + "-" + goodId, seckillOrderInfo);
    }

    @Override
    public SeckillOrderInfo getSeckillOrder(int userId, int goodId) {
        return redisUtil.get(OrderKey.SECKILL_ORDER, userId + "-" + goodId, SeckillOrderInfo.class);
    }

    @Override
    public void setGoodStatus(int goodId) {
        redisUtil.set(SeckillKey.IS_GOOD_OVER, goodId + "", true);
    }

    @Override
    public boolean getGoodStatus(int goodId) {
        return redisUtil.exist(SeckillKey.IS_GOOD_OVER, goodId + "");
    }
}
