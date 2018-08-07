package pers.pk.seckill.domain;


/**
 * @author panke
 * @date created in 8/6/18 3:44 PM
 */
public class SeckillInfo {

    private Integer userId;
    private Integer goodId;

    public SeckillInfo() {
    }

    public SeckillInfo(Integer userId, Integer goodId) {
        this.userId = userId;
        this.goodId = goodId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }
}
