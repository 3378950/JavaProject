package com.neuedu.entity;

import java.sql.Date;

import com.neuedu.annotation.Column;
import com.neuedu.annotation.Table;

@Table("cmt_category")
public class Category {
	private Integer id;
	@Column("parent_id")
	private Integer parentId;
	private String name;
	private Integer status;
	@Column("sort_order")
	private Integer sortOrder;
	@Column("create_time")
	private Date createTime;
	@Column("update_time")
	private Date updateTime;

	public Category() {
		super();
	}

	public Category(Integer id, Integer parentId, String name, Integer status, Integer sortOrder, Date createTime,
			Date updateTime) {
		super();
		this.id = id;
		this.parentId = parentId;
		this.name = name;
		this.status = status;
		this.sortOrder = sortOrder;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
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
		return "Category [id=" + id + ", parentId=" + parentId + ", name=" + name + ", status=" + status
				+ ", sortOrder=" + sortOrder + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}

	public String attributeToString() {
		return " " + id + " " + parentId + " " + name + " " + status
				+ " " + sortOrder + " " + createTime + " " + updateTime;
	}

}
