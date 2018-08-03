package pers.pk.seckill.dev.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.pk.seckill.dev.service.GoodService;
import pers.pk.seckill.dev.service.OrderService;
import pers.pk.seckill.dev.service.SeckillService;
import pers.pk.seckill.domain.GoodVo;
import pers.pk.seckill.domain.OrderInfo;

/**
 * @author panke
 * @date created in 8/3/18 4:38 PM
 */

@Service
public class SeckillServiceImpl implements SeckillService {

    private OrderService orderService;
    private GoodService goodService;

    @Autowired
    public SeckillServiceImpl(OrderService orderService, GoodService goodService) {
        this.orderService = orderService;
        this.goodService = goodService;
    }

    @Override
    @Transactional
    public OrderInfo submitSeckillOrder(int userId, GoodVo goodVo) {
        int row = goodService.reduceStock(goodVo);
        return orderService.createOrder(userId, goodVo);
    }


}
