package pers.pk.seckill.dev.service;

import pers.pk.seckill.domain.GoodVo;
import pers.pk.seckill.domain.OrderInfo;
import pers.pk.seckill.domain.SeckillOrderInfo;

/**
 * @author panke
 * @date created in 8/3/18 5:00 PM
 */
public interface OrderService {

    SeckillOrderInfo getSeckillOrder(int userId, int goodId);

    OrderInfo createOrder(int userId, GoodVo goodVo);
}
