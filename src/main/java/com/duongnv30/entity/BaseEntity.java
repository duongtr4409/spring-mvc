package com.duongnv30.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {
	
	@Column(name = "createby", columnDefinition = "nvarchar(89) DEFAULT(N'ADMIN')")
	private String createBy;
	
	@Column(name = "createdate", columnDefinition = "datetime DEFAULT(GETDATE())")
	private Date createDate;
	
	@Column(name = "modifiesby", columnDefinition = "nvarchar(89) DEFAULT(N'ADMIN')")
	private String modifiesBy;
	
	@Column(name = "modifieddate", columnDefinition = "datetime DEFAULT(GETDATE())")
	private Date modifiedDate;

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getModifiesBy() {
		return modifiesBy;
	}

	public void setModifiesBy(String modifiesBy) {
		this.modifiesBy = modifiesBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	
}
