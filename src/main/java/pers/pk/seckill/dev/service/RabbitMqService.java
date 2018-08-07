package pers.pk.seckill.dev.service;

import pers.pk.seckill.domain.SeckillInfo;

/**
 * @author panke
 * @date created in 8/7/18 2:30 PM
 */
public interface RabbitMqService {

    /**
     * 将秒杀信息入列
     *
     * @param seckillInfo 用户id & 秒杀商品id
     */
    void enqueueSeckillInfo(SeckillInfo seckillInfo);
}
