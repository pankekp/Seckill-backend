package pers.pk.seckill.dev.service;

import pers.pk.seckill.domain.User;

/**
 * @author panke
 * @date created in 18-8-1 下午2:53
 */
public interface UserService {

    User login(User user);

    User getUserByToken(String token);
}
