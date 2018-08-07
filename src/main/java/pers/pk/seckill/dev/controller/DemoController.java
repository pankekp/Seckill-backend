package pers.pk.seckill.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.pk.seckill.dev.service.UserService;
import pers.pk.seckill.domain.User;
import pers.pk.seckill.util.pojo.Result;
import pers.pk.seckill.util.pojo.Success;

/**
 * @author panke
 * @date created in 8/2/18 2:04 PM
 */

@RestController
public class DemoController {

    private UserService userService;

    @Autowired
    public DemoController(UserService userService) {
        this.userService = userService;
    }
}
