package pers.pk.seckill.domain;

import java.util.Date;

/**
 * @author panke
 * @date created in 8/3/18 2:00 PM
 */
public class SeckillGood {

    private Integer id;
    private Integer goodId;
    private Double seckillPrice;
    private Integer seckillStock;
    private Date start;
    private Date end;

    public SeckillGood() {
    }

    public SeckillGood(Integer id, Integer goodId, Double seckillPrice, Integer seckillStock, Date start, Date end) {
        this.id = id;
        this.goodId = goodId;
        this.seckillPrice = seckillPrice;
        this.seckillStock = seckillStock;
        this.start = start;
        this.end = end;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

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
