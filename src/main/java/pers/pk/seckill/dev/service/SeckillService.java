package pers.pk.seckill.dev.service;

import pers.pk.seckill.domain.GoodVo;
import pers.pk.seckill.domain.OrderInfo;

/**
 * @author panke
 * @date created in 8/3/18 4:37 PM
 */
public interface SeckillService {

    OrderInfo submitSeckillOrder(int userId, GoodVo goodVo);
}
