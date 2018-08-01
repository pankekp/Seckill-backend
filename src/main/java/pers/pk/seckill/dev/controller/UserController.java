package pers.pk.seckill.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.pk.seckill.dev.service.UserService;
import pers.pk.seckill.domain.User;
import pers.pk.seckill.util.exception.LoginException;
import pers.pk.seckill.util.pojo.Result;
import pers.pk.seckill.util.pojo.Success;

/**
 * @author panke
 * @date created in 18-8-1 下午2:26
 */

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public Result<User> login(User user) {
        User existUser = userService.login(user);
        if (existUser == null) {
            throw new LoginException();
        }
        return Result.success(Success.LOGIN_SUCCESS, new User(null, existUser.getUsername(), null));
    }
}
