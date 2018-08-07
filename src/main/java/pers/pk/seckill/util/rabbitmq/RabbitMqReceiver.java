package pers.pk.seckill.util.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pers.pk.seckill.dev.service.GoodService;
import pers.pk.seckill.dev.service.OrderService;
import pers.pk.seckill.dev.service.SeckillService;
import pers.pk.seckill.domain.GoodVo;
import pers.pk.seckill.domain.OrderInfo;
import pers.pk.seckill.domain.SeckillInfo;
import pers.pk.seckill.domain.SeckillOrderInfo;
import pers.pk.seckill.util.redis.RedisUtil;

/**
 * @author panke
 * @date created in 8/6/18 2:10 PM
 */

@Component
public class RabbitMqReceiver {

    private GoodService goodService;
    private OrderService orderService;
    private SeckillService seckillService;

    @Autowired
    public RabbitMqReceiver(GoodService goodService, OrderService orderService, SeckillService seckillService) {
        this.goodService = goodService;
        this.orderService = orderService;
        this.seckillService = seckillService;
    }

    @RabbitListener(queues = RabbitMqConfig.SECKILLQUEUE)
    public void receive(String message) {
        SeckillInfo seckillInfo = RedisUtil.strToObj(message, SeckillInfo.class);
        int userId = seckillInfo.getUserId();
        int goodId = seckillInfo.getGoodId();

        //判断是否还有库存
        GoodVo goodVo = goodService.getGood(goodId);
        if (goodVo.getSeckillStock() <= 0) {
            return;
        }

        //将秒杀订单写入数据库并写入redis以供查询
        OrderInfo orderInfo = seckillService.submitSeckillOrder(userId, goodVo);
    }
}
