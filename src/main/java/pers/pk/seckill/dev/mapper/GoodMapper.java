package pers.pk.seckill.dev.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import pers.pk.seckill.domain.GoodSeckillVo;
import pers.pk.seckill.domain.GoodVo;

import java.util.List;

/**
 * @author panke
 * @date created in 8/3/18 2:24 PM
 */

@Mapper
public interface GoodMapper {

    @Select("select g.*, sg.seckill_price, sg.seckill_stock, sg.start, sg.end from seckill_good sg left outer join good g on g.id = sg.id")
    List<GoodVo> getGoodVos();

    @Select("select g.*, sg.seckill_price, sg.seckill_stock, sg.start, sg.end from seckill_good sg left outer join good g on g.id = sg.id where g.id=#{id}")
    GoodSeckillVo getGoodVo(@Param("id") int goodId);

    @Update("update seckill_good set seckill_stock=seckill_stock-1 where good_id=#{goodId} and seckill_stock>0")
    int updateGoodStock(@Param("goodId") int goodId);
}
