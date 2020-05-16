package com.neuedu.entity;

import java.util.Date;

import com.neuedu.annotation.Column;
import com.neuedu.annotation.Table;

@Table("umt_user")
public class User {
	private Integer id;
	private String username;
	private String password;
	private String email;
	private String phone;
	private Integer role;
	@Column("create_time")
	private Date createTime;
	@Column("update_time")
	private Date updateTime;

	public User() {
		super();
	}

	public User(Integer id, String username, String password, String email, String phone, Integer role, Date createTime,
			Date updateTime) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.role = role;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
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
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", phone="
				+ phone + ", role=" + role + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}

}
