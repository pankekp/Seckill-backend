package pers.pk.seckill.domain;

/**
 * @author panke
 * @date created in 8/3/18 3:34 PM
 */
public class GoodSeckillVo extends GoodVo {

    private Integer status;
    private Integer remainSecs;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getRemainSecs() {
        return remainSecs;
    }

    public void setRemainSecs(Integer remainSecs) {
        this.remainSecs = remainSecs;
    }
}
