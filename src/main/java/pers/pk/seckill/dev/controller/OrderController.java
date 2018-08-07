package pers.pk.seckill.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pers.pk.seckill.dev.service.OrderService;
import pers.pk.seckill.domain.OrderInfo;
import pers.pk.seckill.util.pojo.Result;
import pers.pk.seckill.util.pojo.Success;

/**
 * @author panke
 * @date created in 8/7/18 7:19 PM
 */

@RestController
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/order/{orderId}")
    public Result<OrderInfo> getOrderInfo(@PathVariable int orderId) {
        System.out.println(orderId);
        OrderInfo orderInfo = orderService.getOrderInfo(orderId);
        return Result.success(Success.QUERY_SUCCESS, orderInfo);
    }
}
