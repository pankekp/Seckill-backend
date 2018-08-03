package pers.pk.seckill.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pers.pk.seckill.dev.service.GoodService;
import pers.pk.seckill.domain.GoodSeckillVo;
import pers.pk.seckill.domain.GoodVo;
import pers.pk.seckill.util.pojo.Result;
import pers.pk.seckill.util.pojo.Success;

import java.util.List;

/**
 * @author panke
 * @date created in 8/3/18 2:51 PM
 */

@RestController
public class GoodController {

    private GoodService goodService;

    @Autowired
    public GoodController(GoodService goodService) {
        this.goodService = goodService;
    }

    @GetMapping("/goods")
    public Result<List<GoodVo>> getGoods() {
        List<GoodVo> goodVos = goodService.getGoods();
        return Result.success(Success.QUERY_SUCCESS, goodVos);
    }

    @GetMapping("/good/{goodId}")
    public Result<GoodSeckillVo> getGood(@PathVariable("goodId") int goodId) {
        GoodSeckillVo goodSeckillVo = goodService.getGood(goodId);

        long start = goodSeckillVo.getStart().getTime();
        long end = goodSeckillVo.getEnd().getTime();
        long current = System.currentTimeMillis();

        int seckillStatus;
        int remainSecs;

        if (current < start) {
            seckillStatus = 0;
            remainSecs = (int) ((start - current) / 1000);
        } else if (current > end) {
            seckillStatus = 2;
            remainSecs = -1;
        } else {
            seckillStatus = 1;
            remainSecs = 0;
        }
        goodSeckillVo.setStatus(seckillStatus);
        goodSeckillVo.setRemainSecs(remainSecs);
        return Result.success(Success.QUERY_SUCCESS, goodSeckillVo);
    }
}
