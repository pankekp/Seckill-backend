package pers.pk.seckill.dev.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.pk.seckill.dev.service.RabbitMqService;
import pers.pk.seckill.domain.SeckillInfo;
import pers.pk.seckill.util.rabbitmq.RabbitMqSender;

/**
 * @author panke
 * @date created in 8/7/18 2:44 PM
 */

@Service
public class RabbitMqServiceImpl implements RabbitMqService {

    private RabbitMqSender rabbitMqSender;

    @Autowired
    public RabbitMqServiceImpl(RabbitMqSender rabbitMqSender) {
        this.rabbitMqSender = rabbitMqSender;
    }


    @Override
    public void enqueueSeckillInfo(SeckillInfo seckillInfo) {
        rabbitMqSender.sendSeckillMessage(seckillInfo);
    }
}
