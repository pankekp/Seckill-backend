package pers.pk.seckill.util.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author panke
 * @date created in 8/6/18 2:10 PM
 */

@Configuration
public class RabbitMqConfig {

    public static final String SECKILLQUEUE = "seckillQueue";

    @Bean
    public Queue queue() {
        return new Queue(SECKILLQUEUE, true);
    }
}
