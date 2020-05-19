package com.neuedu.entity;

import java.sql.Date;

import com.neuedu.annotation.Column;
import com.neuedu.annotation.Table;

@Table("umt_shipping")
public class Shipping {
	private Integer id;
	@Column("user_id")
	private Integer userId;
	@Column("receiver_name")
	private String receiverName;
	@Column("receiver_phone")
	private String receiverPhone;
	@Column("receiver_province")
	private String receiverProvince;
	@Column("receiver_city")
	private String receiverCity;
	private String district;
	@Column("receiver_address")
	private String receiverAddress;
	@Column("receiver_zip")
	private String receiverZip;
	@Column("create_time")
	private Date createTime;
	@Column("update_time")
	private Date updateTime;
	
	public Shipping() {
		super();
	}

	public Shipping(Integer id, Integer userId, String receiverName, String receiverPhone, String receiverProvince,
			String receiverCity, String district, String receiverAddress, String receiverZip, Date createTime,
			Date updateTime) {
		super();
		this.id = id;
		this.userId = userId;
		this.receiverName = receiverName;
		this.receiverPhone = receiverPhone;
		this.receiverProvince = receiverProvince;
		this.receiverCity = receiverCity;
		this.district = district;
		this.receiverAddress = receiverAddress;
		this.receiverZip = receiverZip;
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

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverPhone() {
		return receiverPhone;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	public String getReceiverProvince() {
		return receiverProvince;
	}

	public void setReceiverProvince(String receiverProvince) {
		this.receiverProvince = receiverProvince;
	}

	public String getReceiverCity() {
		return receiverCity;
	}

	public void setReceiverCity(String receiverCity) {
		this.receiverCity = receiverCity;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public String getReceiverZip() {
		return receiverZip;
	}

	public void setReceiverZip(String receiverZip) {
		this.receiverZip = receiverZip;
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
		return "Shipping [id=" + id + ", userId=" + userId + ", receiverName=" + receiverName + ", receiverPhone="
				+ receiverPhone + ", receiverProvince=" + receiverProvince + ", receiverCity=" + receiverCity
				+ ", district=" + district + ", receiverAddress=" + receiverAddress + ", receiverZip=" + receiverZip
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}
	
	public String attributeToString() {
		return " " + id + " " + userId + " " + receiverName + " "
				+ receiverPhone + " " + receiverProvince + " " + receiverCity
				+ " " + district + " " + receiverAddress + " " + receiverZip
				+ " " + createTime + " " + updateTime ;
	}
	
}
