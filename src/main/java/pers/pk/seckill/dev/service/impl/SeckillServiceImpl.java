package pers.pk.seckill.dev.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.pk.seckill.dev.service.GoodService;
import pers.pk.seckill.dev.service.OrderService;
import pers.pk.seckill.dev.service.RedisService;
import pers.pk.seckill.dev.service.SeckillService;
import pers.pk.seckill.domain.GoodVo;
import pers.pk.seckill.domain.OrderInfo;
import pers.pk.seckill.domain.SeckillOrderInfo;

/**
 * @author panke
 * @date created in 8/3/18 4:38 PM
 */

@Service
public class SeckillServiceImpl implements SeckillService {

    private OrderService orderService;
    private GoodService goodService;
    private RedisService redisService;

    @Autowired
    public SeckillServiceImpl(OrderService orderService, GoodService goodService, RedisService redisService) {
        this.redisService = redisService;
        this.orderService = orderService;
        this.goodService = goodService;
    }

    @Override
    @Transactional
    public OrderInfo submitSeckillOrder(int userId, GoodVo goodVo) {
        int row = goodService.reduceStock(goodVo);
        //减库存失败说明已经被秒杀完，在redis中标记此商品
        if (row == 1) {
            return orderService.createOrder(userId, goodVo);
        } else {
            redisService.setGoodStatus(goodVo.getId());
            return null;
        }
    }

    @Override
    public int getSeckillResult(int userId, int goodId) {
        SeckillOrderInfo seckillOrderInfo = orderService.getSeckillOrder(userId, goodId);
        if (seckillOrderInfo != null) {
            return seckillOrderInfo.getOrderInfoId();
        } else {
            if (redisService.getGoodStatus(goodId)) {
                return -1;
            } else {
                //由于前段轮询秒杀结果与队列异步处理是并发进行的，所以有可能仍处于排队中的的状态
                return 0;
            }
        }
    }
}
