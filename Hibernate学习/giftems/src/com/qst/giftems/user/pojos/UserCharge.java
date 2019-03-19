package com.qst.giftems.user.pojos;

import java.util.Date;

/**
 * 账户（U币）记录（充值、消费、奖励等）
 */
@SuppressWarnings("serial")
public class UserCharge implements java.io.Serializable{
	
    /**
     * 主键
     */
    private Integer id;
    /**
     * 充值用户
     */
    private Integer userId;
    /**
     * 记录描述（充值、报班、打卡等）
     */
    private String content;
    /**
     * 记录时间
     */
    private Date createTime;
    /**
     * 收支金额
     */
    private Float coin;
    /**
     * 类型 1:充值记录，2：打卡记录，3：消费记录 ,4 注册
     */
    private Integer type;

    public UserCharge() {}

    public UserCharge(Integer userId, Integer clazzId,
            String content, Date createTime, Float coin, Integer type) {
        this.userId = userId;
        this.content = content;
        this.createTime = createTime;
        this.coin = coin;
        this.type = type;
    }

    /***************************************************************************
     * Getters/Setters
     **************************************************************************/
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Float getCoin() {
        return coin;
    }

    public void setCoin(Float coin) {
        this.coin = coin;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
