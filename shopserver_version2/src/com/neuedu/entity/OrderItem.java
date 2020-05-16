package com.neuedu.entity;

import java.math.BigDecimal;
import java.sql.Date;

import com.neuedu.annotation.Column;
import com.neuedu.annotation.Table;

@Table("omt_order_item")
public class OrderItem {
	private Integer id;
	@Column("user_id")
	private Integer userId;
	@Column("order_no")
	private BigDecimal orderNo;
	@Column("product_id")
	private BigDecimal productId;
	@Column("product_name")
	private String productName;
	@Column("product_image")
	private String productImage;
	@Column("current_unit_price")
	private BigDecimal currentUnitPrice;
	private Integer quantity;
	@Column("total_price")
	private BigDecimal totalPrice;
	@Column("creat_time")
	private Date createTime;
	@Column("update_time")
	private Date updateTime;
	
	public OrderItem() {
		super();
	}

	public OrderItem(Integer id, Integer userId, BigDecimal orderNo, BigDecimal productId, String productName,
			String productImage, BigDecimal currentUnitPrice, Integer quantity, BigDecimal totalPrice, Date createTime,
			Date updateTime) {
		super();
		this.id = id;
		this.userId = userId;
		this.orderNo = orderNo;
		this.productId = productId;
		this.productName = productName;
		this.productImage = productImage;
		this.currentUnitPrice = currentUnitPrice;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
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

	public BigDecimal getProductId() {
		return productId;
	}

	public void setProductId(BigDecimal productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public BigDecimal getCurrentUnitPrice() {
		return currentUnitPrice;
	}

	public void setCurrentUnitPrice(BigDecimal currentUnitPrice) {
		this.currentUnitPrice = currentUnitPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
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
		return "OrderItem [id=" + id + ", userId=" + userId + ", orderNo=" + orderNo + ", productId=" + productId
				+ ", productName=" + productName + ", productImage=" + productImage + ", currentUnitPrice="
				+ currentUnitPrice + ", quantity=" + quantity + ", totalPrice=" + totalPrice + ", createTime="
				+ createTime + ", updateTime=" + updateTime + "]";
	}

	
	
	
}
