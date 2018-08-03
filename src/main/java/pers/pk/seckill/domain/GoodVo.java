package pers.pk.seckill.domain;

import java.util.Date;

/**
 * @author panke
 * @date created in 8/3/18 2:24 PM
 */
public class GoodVo extends Good {

    private Double seckillPrice;
    private Integer seckillStock;
    private Date start;
    private Date end;

    public Double getSeckillPrice() {
        return seckillPrice;
    }

    public void setSeckillPrice(Double seckillPrice) {
        this.seckillPrice = seckillPrice;
    }

    public Integer getSeckillStock() {
        return seckillStock;
    }

    public void setSeckillStock(Integer seckillStock) {
        this.seckillStock = seckillStock;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
