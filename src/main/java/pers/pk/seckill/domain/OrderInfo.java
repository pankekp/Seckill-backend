package pers.pk.seckill.domain;

import java.util.Date;

/**
 * @author panke
 * @date created in 8/3/18 2:02 PM
 */
public class OrderInfo {

    private Integer id;
    private Integer userId;
    private Integer goodId;
    private Integer contactInfoId;
    private String goodName;
    private Integer num;
    private Double price;
    private Integer status;
    private Date createTime;
    private Date payTime;

    public OrderInfo() {
    }

    public OrderInfo(Integer id, Integer userId, Integer goodId, Integer contactInfoId, String goodName, Integer num, Double price, Integer status, Date createTime, Date payTime) {
        this.id = id;
        this.userId = userId;
        this.goodId = goodId;
        this.contactInfoId = contactInfoId;
        this.goodName = goodName;
        this.num = num;
        this.price = price;
        this.status = status;
        this.createTime = createTime;
        this.payTime = payTime;
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

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public Integer getContactInfoId() {
        return contactInfoId;
    }

    public void setContactInfoId(Integer contactInfoId) {
        this.contactInfoId = contactInfoId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }
}
