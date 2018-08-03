package pers.pk.seckill.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.pk.seckill.dev.service.GoodService;
import pers.pk.seckill.dev.service.OrderService;
import pers.pk.seckill.dev.service.SeckillService;
import pers.pk.seckill.domain.GoodVo;
import pers.pk.seckill.domain.OrderInfo;
import pers.pk.seckill.domain.SeckillGood;
import pers.pk.seckill.domain.SeckillOrderInfo;
import pers.pk.seckill.util.exception.SeckillFailedException;
import pers.pk.seckill.util.pojo.Error;
import pers.pk.seckill.util.pojo.Result;
import pers.pk.seckill.util.pojo.Success;

/**
 * @author panke
 * @date created in 8/3/18 4:36 PM
 */

@RestController
public class SeckillController {

    private GoodService goodService;
    private OrderService orderService;
    private SeckillService seckillService;

    @Autowired
    public SeckillController(GoodService goodService, OrderService orderService, SeckillService seckillService) {
        this.goodService = goodService;
        this.orderService = orderService;
        this.seckillService = seckillService;
    }

    @PostMapping("/seckill")
    public Result<OrderInfo> seckill(@RequestBody OrderInfo orderInfoToAdd) {
        int userId = orderInfoToAdd.getUserId();
        int goodId = orderInfoToAdd.getGoodId();
        GoodVo goodVo = goodService.getGood(goodId);
        if (goodVo.getSeckillStock() <= 0) {
            throw new SeckillFailedException(Error.STOCK_NULL_ERROR);
        }
        SeckillOrderInfo seckillOrderInfo = orderService.getSeckillOrder(userId, goodId);
        if (seckillOrderInfo != null) {
            throw new SeckillFailedException(Error.SECKILL_REPEATED_ERROR);
        }
        OrderInfo orderInfo = seckillService.submitSeckillOrder(userId, goodVo);
        return Result.success(Success.SECKILL_SUCCESS, orderInfo);
    }
}
