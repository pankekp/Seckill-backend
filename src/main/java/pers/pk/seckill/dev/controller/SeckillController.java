package pers.pk.seckill.dev.controller;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.pk.seckill.dev.service.GoodService;
import pers.pk.seckill.dev.service.OrderService;
import pers.pk.seckill.dev.service.RabbitMqService;
import pers.pk.seckill.dev.service.RedisService;
import pers.pk.seckill.dev.service.SeckillService;
import pers.pk.seckill.dev.service.UserService;
import pers.pk.seckill.domain.GoodVo;
import pers.pk.seckill.domain.OrderInfo;
import pers.pk.seckill.domain.SeckillInfo;
import pers.pk.seckill.domain.SeckillOrderInfo;
import pers.pk.seckill.domain.User;
import pers.pk.seckill.util.exception.SeckillFailedException;
import pers.pk.seckill.util.pojo.Error;
import pers.pk.seckill.util.pojo.Result;
import pers.pk.seckill.util.pojo.Success;

import java.util.List;

/**
 * @author panke
 * @date created in 8/3/18 4:36 PM
 */

@RestController
public class SeckillController implements InitializingBean {

    private GoodService goodService;
    private OrderService orderService;
    private SeckillService seckillService;
    private RedisService redisService;
    private RabbitMqService rabbitMqService;

    @Autowired
    public SeckillController(GoodService goodService, OrderService orderService, SeckillService seckillService,
                             RedisService redisService, RabbitMqService rabbitMqService) {
        this.rabbitMqService = rabbitMqService;
        this.redisService = redisService;
        this.goodService = goodService;
        this.orderService = orderService;
        this.seckillService = seckillService;
    }

    @PostMapping("/seckill")
    public Result<String> seckill(@CookieValue("token") String token, @RequestBody OrderInfo orderInfo) {
        User user = redisService.getUser(token);
        int userId = user.getId();
        int goodId = orderInfo.getGoodId();

        //redis中预减库存
        //一旦库存为0直接返回秒杀失败
        long stock = redisService.decreaseStock(goodId);
        if (stock < 0) {
            throw new SeckillFailedException(Error.STOCK_NULL_ERROR);
        }

        //redis中查询是否已存在秒杀订单
        //若已查到该用户该商品的秒杀订单直接返回秒杀重复
        SeckillOrderInfo seckillOrderInfo = orderService.getSeckillOrder(userId, goodId);
        if (seckillOrderInfo != null) {
            throw new SeckillFailedException(Error.SECKILL_REPEATED_ERROR);
        }

        //入列，注意能入列的数量不一定刚好等于库存数量，所以队列异步处理订单时仍需要进行库存与重复秒杀的判断
        SeckillInfo seckillInfo = new SeckillInfo(userId, goodId);
        rabbitMqService.enqueueSeckillInfo(seckillInfo);

        //返回排队中的提示
        return Result.success(Success.QUEUING, null);
    }

    @GetMapping("/seckillrResult")
    public Result<Integer> seckillResut(@CookieValue("token") String token, int goodId) {
        User user = redisService.getUser(token);
        int result = seckillService.getSeckillResult(user.getId(), goodId);
        if (result == 0) {
            return Result.success(Success.QUEUING, 0);
        } else if (result == -1) {
            return Result.error(Error.SECKILL_FAILED_ERROR);
        } else {
            return Result.success(Success.SECKILL_SUCCESS, result);
        }
    }

    /**
     * 系统初始化，将库存加载至redis中
     */
    @Override
    public void afterPropertiesSet() {
        List<GoodVo> goodVos = goodService.getGoods();
        if (goodVos == null) {
            return;
        }
        for (GoodVo goodVo : goodVos) {
            redisService.loadStockToCache(goodVo.getId(), goodVo.getSeckillStock());
        }
    }
}
