package pers.pk.seckill.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.pk.seckill.dev.service.UserService;
import pers.pk.seckill.domain.User;
import pers.pk.seckill.util.exception.LoginException;
import pers.pk.seckill.util.pojo.Info;
import pers.pk.seckill.util.pojo.Result;
import pers.pk.seckill.util.pojo.Success;
import pers.pk.seckill.util.redis.RedisUtil;
import pers.pk.seckill.util.redis.key.UserKey;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author panke
 * @date created in 18-8-1 下午2:26
 */

@RestController
public class UserController {

    private UserService userService;
    private RedisUtil redisUtil;

    @Autowired
    public UserController(UserService userService, RedisUtil redisUtil) {
        this.userService = userService;
        this.redisUtil = redisUtil;
    }

    @GetMapping("/login")
    public Result<User> login(User user, HttpServletResponse response) {
        User existUser = userService.login(user);
        if (existUser == null) {
            throw new LoginException();
        }
        String token = UUID.randomUUID().toString().replace("-", "");
        redisUtil.set(UserKey.TOKEN, token, user);
        Cookie cookie = new Cookie(Info.COOKIE_TOKEN.getInfo(), token);
        cookie.setPath("/");
        response.addCookie(cookie);
        return Result.success(Success.LOGIN_SUCCESS, new User(existUser.getId(), existUser.getUsername(), null));
    }

}
