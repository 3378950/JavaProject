package com.neuedu.entity;

import java.math.BigDecimal;
import java.sql.Date;

import com.neuedu.annotation.Column;
import com.neuedu.annotation.Table;

@Table("omt_order")
public class Order {
	private Integer id;
	@Column("corder_no")
	private Integer orderNo;
	@Column("user_id")
	private Integer userId;
	@Column("shipping_id")
	private Integer shippingId;
	private BigDecimal payment;
	private Integer paymentType;
	private Integer postage;
	private Integer status;
	@Column("payment_time")
	private Date paymentTime;
	@Column("send_time")
	private Date sendTime;
	@Column("end_time")
	private Date endTime;
	@Column("close_time")
	private Date closeTime;
	@Column("create_time")
	private Date createTime;
	@Column("update_time")
	private Date updateTime;

	public Order() {
		super();
	}

	public Order(Integer id, Integer orderNo, Integer userId, Integer shippingId, BigDecimal payment,
			Integer paymentType, Integer postage, Integer status, Date paymentTime, Date sendTime, Date endTime,
			Date closeTime, Date createTime, Date updateTime) {
		super();
		this.id = id;
		this.orderNo = orderNo;
		this.userId = userId;
		this.shippingId = shippingId;
		this.payment = payment;
		this.paymentType = paymentType;
		this.postage = postage;
		this.status = status;
		this.paymentTime = paymentTime;
		this.sendTime = sendTime;
		this.endTime = endTime;
		this.closeTime = closeTime;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getShippingId() {
		return shippingId;
	}

	public void setShippingId(Integer shippingId) {
		this.shippingId = shippingId;
	}

	public BigDecimal getPayment() {
		return payment;
	}

	public void setPayment(BigDecimal payment) {
		this.payment = payment;
	}

	public Integer getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(Integer paymentType) {
		this.paymentType = paymentType;
	}

	public Integer getPostage() {
		return postage;
	}

	public void setPostage(Integer postage) {
		this.postage = postage;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getPaymentTime() {
		return paymentTime;
	}

	public void setPaymentTime(Date paymentTime) {
		this.paymentTime = paymentTime;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(Date closeTime) {
		this.closeTime = closeTime;
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
		return "Order [id=" + id + ", orderNo=" + orderNo + ", userId=" + userId + ", shippingId=" + shippingId
				+ ", payment=" + payment + ", paymentType=" + paymentType + ", postage=" + postage + ", status="
				+ status + ", paymentTime=" + paymentTime + ", sendTime=" + sendTime + ", endTime=" + endTime
				+ ", closeTime=" + closeTime + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}
	
	public String attributeToString() {
		return " " + id + " " + orderNo + " " + userId + " " + shippingId
				+ " " + payment + " " + paymentType + " " + postage + " "
				+ status + " " + paymentTime + " " + sendTime + " " + endTime
				+ " " + closeTime + " " + createTime + " " + updateTime;
	}
}
