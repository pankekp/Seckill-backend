package pers.pk.seckill.dev.service;

import pers.pk.seckill.domain.GoodSeckillVo;
import pers.pk.seckill.domain.GoodVo;

import java.util.List;

/**
 * @author panke
 * @date created in 8/3/18 2:33 PM
 */
public interface GoodService {

    List<GoodVo> getGoods();

    GoodSeckillVo getGood(int goodId);

    int reduceStock(GoodVo goodVo);
}
