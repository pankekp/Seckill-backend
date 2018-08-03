package pers.pk.seckill.dev.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.pk.seckill.dev.mapper.GoodMapper;
import pers.pk.seckill.dev.service.GoodService;
import pers.pk.seckill.domain.GoodSeckillVo;
import pers.pk.seckill.domain.GoodVo;
import pers.pk.seckill.domain.SeckillGood;

import java.util.List;

/**
 * @author panke
 * @date created in 8/3/18 2:34 PM
 */

@Service
public class GoodServiceImpl implements GoodService {

    private GoodMapper goodMapper;

    @Autowired
    public GoodServiceImpl(GoodMapper goodMapper) {
        this.goodMapper = goodMapper;
    }

    @Override
    public List<GoodVo> getGoods() {
        return goodMapper.getGoodVos();
    }

    @Override
    public GoodSeckillVo getGood(int goodId) {
        return goodMapper.getGoodVo(goodId);
    }

    @Override
    public int reduceStock(GoodVo goodVo) {
        return goodMapper.updateGoodStock(goodVo.getId());
    }
}
