package pers.pk.seckill.dev.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.pk.seckill.dev.mapper.UserMapper;
import pers.pk.seckill.dev.service.UserService;
import pers.pk.seckill.domain.User;

/**
 * @author panke
 * @date created in 18-8-1 下午2:53
 */

@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User login(User user) {
        return userMapper.getUser(user);
    }
}
