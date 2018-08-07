package pers.pk.seckill.dev.service;

import pers.pk.seckill.domain.GoodVo;
import pers.pk.seckill.domain.OrderInfo;
import pers.pk.seckill.domain.SeckillOrderInfo;

/**
 * @author panke
 * @date created in 8/3/18 5:00 PM
 */
public interface OrderService {

    /**
     * 从redis中获取秒杀订单
     *
     * @param userId 用户id
     * @param goodId 商品id
     * @return 返回秒杀订单
     */
    SeckillOrderInfo getSeckillOrder(int userId, int goodId);

    /**
     * 将秒杀订单写入数据库同时写入redis
     *
     * @param userId 用户id
     * @param goodVo 秒杀商品
     * @return 订单信息
     */
    OrderInfo createOrder(int userId, GoodVo goodVo);

    /**
     * 查询订单详情
     *
     * @param orderId 订单id
     * @return 订单详情
     */
    OrderInfo getOrderInfo(int orderId);
}
