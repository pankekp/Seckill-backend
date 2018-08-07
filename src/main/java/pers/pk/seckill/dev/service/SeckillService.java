package pers.pk.seckill.dev.service;

import pers.pk.seckill.domain.GoodVo;
import pers.pk.seckill.domain.OrderInfo;

/**
 * @author panke
 * @date created in 8/3/18 4:37 PM
 */
public interface SeckillService {

    /**
     * 减库存，创建秒杀订单
     *
     * @param userId 用户id
     * @param goodVo 秒杀商品
     * @return 如果提交成功则返回订单信息，否则将此商品标记为卖空，返回null
     */
    OrderInfo submitSeckillOrder(int userId, GoodVo goodVo);

    /**
     * 查询redis中的秒杀订单，返回结果
     *
     * @param userId 用户id
     * @param goodId 商品id
     * @return 秒杀成功：orderId/秒杀失败：-1/仍然排队中：0
     */
    int getSeckillResult(int userId, int goodId);
}
