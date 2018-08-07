package pers.pk.seckill.dev.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import pers.pk.seckill.domain.OrderInfo;
import pers.pk.seckill.domain.SeckillOrderInfo;

/**
 * @author panke
 * @date created in 8/3/18 4:49 PM
 */

@Mapper
public interface OrderMapper {


    @Select("select * from seckill_order_info where user_id=#{userId} and good_id=#{goodId}")
    SeckillOrderInfo getSeckillOrder(@Param("userId") int userId, @Param("goodId") int goodId);

    @Insert("insert into order_info(user_id,good_id,contact_info_id,good_name,num,price,status,create_time)" +
            "values(#{userId},#{goodId},#{contactInfoId},#{goodName},#{num},#{price},#{status},#{createTime})")
    @SelectKey(keyColumn = "id", keyProperty = "id", resultType = int.class, before = false, statement = "select last_insert_id()")
    int insertOrder(OrderInfo orderInfo);

    @Insert("insert into seckill_order_info(user_id,good_id,order_info_id) values(#{userId},#{goodId},#{orderInfoId})")
    int insertSeckillOrder(SeckillOrderInfo seckillOrderInfo);

    @Select("select * from order_info where id=#{id}")
    OrderInfo getOrderInfo(int id);
}
