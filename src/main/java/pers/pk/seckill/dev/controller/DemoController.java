package pers.pk.seckill.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.pk.seckill.dev.service.UserService;
import pers.pk.seckill.domain.User;
import pers.pk.seckill.util.pojo.Info;
import pers.pk.seckill.util.pojo.Result;
import pers.pk.seckill.util.pojo.Success;
import pers.pk.seckill.util.redis.RedisUtil;
import pers.pk.seckill.util.redis.key.UserKey;

/**
 * @author panke
 * @date created in 8/2/18 2:04 PM
 */

@RestController
public class DemoController {

    private RedisUtil redisUtil;
    private UserService userService;

    @Autowired
    public DemoController(RedisUtil redisUtil, UserService userService) {
        this.redisUtil = redisUtil;
        this.userService = userService;
    }

    @RequestMapping("/setRedis")
    public String setRedis() {
        redisUtil.set(UserKey.NAME, "test", "test");
        return "success";
    }

    @RequestMapping("/session")
    public Result<User> testSession(@CookieValue("token") String token) {
        User user = userService.getUserByToken(token);
        return Result.success(Success.LOGIN_SUCCESS, user);
    }
}
