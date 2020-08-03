package com.neuedu.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.neuedu.annotation.Column;
import com.neuedu.annotation.Table;

@Table("pmt_product")
public class Product {
	private Integer id;
	@Column("category_id")
	private Integer categoryId;
	private String name;
	private String subtitle;
	@Column("main_image")
	private String mainImage;
	@Column("sub_images")
	private String subImages;
	private String detail;
	private BigDecimal price;
	private Integer stock;
	private Integer status;
	@Column("create_time")
	private Date createTime;
	@Column("update_time")
	private Date updateTime;
	
	public Product() {
		super();
	}

	public Product(Integer id, Integer categoryId, String name, String subtitle, String mainImage, String subImages,
			String detail, BigDecimal price, Integer stock, Integer status, Date createTime, Date updateTime) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.name = name;
		this.subtitle = subtitle;
		this.mainImage = mainImage;
		this.subImages = subImages;
		this.detail = detail;
		this.price = price;
		this.stock = stock;
		this.status = status;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getMainImage() {
		return mainImage;
	}

	public void setMainImage(String mainImage) {
		this.mainImage = mainImage;
	}

	public String getSubImages() {
		return subImages;
	}

	public void setSubImiges(String subImages) {
		this.subImages = subImages;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
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

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String toString() {
		return "Product [id=" + id + ", categoryId=" + categoryId + ", name=" + name + ", subtitle=" + subtitle
				+ ", mainImige=" + mainImage + ", subImiges=" + subImages + ", detail=" + detail + ", price=" + price
				+ ", stock=" + stock + ", status=" + status + ", createTime=" + createTime + ", updateTime="
				+ updateTime + "]";
	}
	
	public String attributeToString() {
		return " " + id + " " + categoryId + " " + name + " " + subtitle
				+ " " + mainImage + " " + subImages + " " + detail + " " + price
				+ " " + stock + " " + status + " " + createTime + " "
				+ updateTime ;
	}
}
