package com.neuedu.entity;

import java.math.BigDecimal;
import java.sql.Date;

import com.neuedu.annotation.Column;
import com.neuedu.annotation.Table;

@Table("omt_pay_info")
public class PayInfo {
	private Integer id;
	@Column("user_id")
	private Integer userId;
	@Column("order_no")
	private BigDecimal orderNo;
	@Column("pay_platform")
	private Integer payPlatform;
	@Column("platform_number")
	private String platformNumber;
	@Column("platform_status")
	private String platformStatus;
	@Column("create_time")
	private Date createTime;
	@Column("update_time")
	private Date updateTime;
	public PayInfo() {
		super();
	}
	public PayInfo(Integer id, Integer userId, BigDecimal orderNo, Integer payPlatform, String platformNumber,
			String platformStatus, Date createTime, Date updateTime) {
		super();
		this.id = id;
		this.userId = userId;
		this.orderNo = orderNo;
		this.payPlatform = payPlatform;
		this.platformNumber = platformNumber;
		this.platformStatus = platformStatus;
		this.createTime = createTime;
		this.updateTime = updateTime;
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
	public BigDecimal getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(BigDecimal orderNo) {
		this.orderNo = orderNo;
	}
	public Integer getPayPlatform() {
		return payPlatform;
	}
	public void setPayPlatform(Integer payPlatform) {
		this.payPlatform = payPlatform;
	}
	public String getPlatformNumber() {
		return platformNumber;
	}
	public void setPlatformNumber(String platformNumber) {
		this.platformNumber = platformNumber;
	}
	public String getPlatformStatus() {
		return platformStatus;
	}
	public void setPlatformStatus(String platformStatus) {
		this.platformStatus = platformStatus;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public String toString() {
		return "PayInfo [id=" + id + ", userId=" + userId + ", orderNo=" + orderNo + ", payPlatform=" + payPlatform
				+ ", platformNumber=" + platformNumber + ", platformStatus=" + platformStatus + ", createTime="
				+ createTime + ", updateTime=" + updateTime + "]";
	}
	
	
	
}
