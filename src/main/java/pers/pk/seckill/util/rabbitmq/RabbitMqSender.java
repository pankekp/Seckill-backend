package pers.pk.seckill.util.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pers.pk.seckill.domain.SeckillInfo;
import pers.pk.seckill.util.redis.RedisUtil;

/**
 * @author panke
 * @date created in 8/6/18 2:09 PM
 */

@Component
public class RabbitMqSender {

    private AmqpTemplate amqpTemplate;

    @Autowired
    public RabbitMqSender(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void sendSeckillMessage(SeckillInfo seckillInfo) {
        String message = RedisUtil.objToStr(seckillInfo);
        amqpTemplate.convertAndSend(RabbitMqConfig.SECKILLQUEUE, message);
    }
}
