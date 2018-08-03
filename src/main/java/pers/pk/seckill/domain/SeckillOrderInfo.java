package pers.pk.seckill.domain;

/**
 * @author panke
 * @date created in 8/3/18 2:05 PM
 */
public class SeckillOrderInfo {

    private Integer id;
    private Integer userId;
    private Integer orderInfoId;
    private Integer goodId;

    public SeckillOrderInfo() {
    }

    public SeckillOrderInfo(Integer id, Integer userId, Integer orderInfoId, Integer goodId) {
        this.id = id;
        this.userId = userId;
        this.orderInfoId = orderInfoId;
        this.goodId = goodId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOrderInfoId() {
        return orderInfoId;
    }

    public void setOrderInfoId(Integer orderInfoId) {
        this.orderInfoId = orderInfoId;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }
}
