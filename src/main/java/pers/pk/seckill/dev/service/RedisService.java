package pers.pk.seckill.dev.service;

import pers.pk.seckill.domain.SeckillOrderInfo;
import pers.pk.seckill.domain.User;

/**
 * @author panke
 * @date created in 8/7/18 2:30 PM
 */
public interface RedisService {

    /**
     * 将用户存在redis中
     *
     * @param user  用户信息
     * @param token key
     */
    void setUser(User user, String token);

    /**
     * 根据token获取用户信息
     *
     * @param token token
     * @return user
     */
    User getUser(String token);

    /**
     * 在redis中预减库存
     *
     * @param goodId 商品id
     * @return 剩余库存
     */
    Long decreaseStock(int goodId);

    /**
     * 将秒杀商品的库存加载到redis中
     *
     * @param goodId 秒杀商品id
     * @param stock  秒杀商品库存
     */
    void loadStockToCache(int goodId, int stock);

    /**
     * 将秒杀订单存放在redis中
     *
     * @param userId 用户id
     * @param goodId 商品id
     */
    void setSeckillOrder(int userId, int goodId, SeckillOrderInfo seckillOrderInfo);

    /**
     * 从redis中获取秒杀订单
     *
     * @param userId 用户id
     * @param goodId 商品id
     * @return 返回秒杀订单
     */
    SeckillOrderInfo getSeckillOrder(int userId, int goodId);

    /**
     * 标记商品是否已经被秒杀空
     *
     * @param goodId 商品id
     */
    void setGoodStatus(int goodId);

    /**
     * 判断商品是否已经被秒杀空
     *
     * @param goodId 商品id
     * @return 仍有商品则返回true
     */
    boolean getGoodStatus(int goodId);

    /**
     * 根据用户id获取访问次数
     *
     * @param userId 用户id
     * @return 访问次数
     */
    Integer getAccessCount(int userId);

    /**
     * 为此用户设置访问次数
     *
     * @param userId 用户id
     */
    void initAccessCount(int userId);

    /**
     * 增加此用户的访问次数
     *
     * @param userId 用户id
     */
    void incrAccessCount(int userId);
}
