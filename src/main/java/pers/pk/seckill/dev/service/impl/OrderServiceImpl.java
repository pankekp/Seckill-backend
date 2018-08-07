package pers.pk.seckill.dev.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.pk.seckill.dev.mapper.OrderMapper;
import pers.pk.seckill.dev.service.OrderService;
import pers.pk.seckill.dev.service.RedisService;
import pers.pk.seckill.domain.GoodVo;
import pers.pk.seckill.domain.OrderInfo;
import pers.pk.seckill.domain.SeckillOrderInfo;
import pers.pk.seckill.util.redis.RedisUtil;
import pers.pk.seckill.util.redis.key.OrderKey;

import java.util.Date;

/**
 * @author panke
 * @date created in 8/3/18 5:00 PM
 */

@Service
public class OrderServiceImpl implements OrderService {

    private OrderMapper orderMapper;
    private RedisService redisService;

    @Autowired
    public OrderServiceImpl(OrderMapper orderMapper, RedisService redisService) {
        this.redisService = redisService;
        this.orderMapper = orderMapper;
    }

    @Override
    public SeckillOrderInfo getSeckillOrder(int userId, int goodId) {
        return redisService.getSeckillOrder(userId, goodId);
    }

    @Override
    @Transactional
    public OrderInfo createOrder(int userId, GoodVo goodVo) {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setCreateTime(new Date());
        orderInfo.setContactInfoId(0);
        orderInfo.setNum(1);
        orderInfo.setGoodId(goodVo.getId());
        orderInfo.setGoodName(goodVo.getName());
        orderInfo.setPrice(goodVo.getSeckillPrice());
        orderInfo.setStatus(0);
        orderInfo.setUserId(userId);
        orderMapper.insertOrder(orderInfo);
        SeckillOrderInfo seckillOrderInfo = new SeckillOrderInfo();
        seckillOrderInfo.setGoodId(goodVo.getId());
        seckillOrderInfo.setOrderInfoId(orderInfo.getId());
        seckillOrderInfo.setUserId(userId);
        orderMapper.insertSeckillOrder(seckillOrderInfo);
        redisService.setSeckillOrder(userId, goodVo.getId(), seckillOrderInfo);
        return orderInfo;
    }

    @Override
    public OrderInfo getOrderInfo(int orderId) {
        return orderMapper.getOrderInfo(orderId);
    }
}
