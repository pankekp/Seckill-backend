package pers.pk.seckill.dev.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import pers.pk.seckill.domain.User;

/**
 * @author panke
 * @date created in 18-8-1 下午2:57
 */

@Mapper
public interface UserMapper {

    @Select("select * from user where username=#{username} and password=#{password}")
    public User getUser(User user);
}
