package com.duongnv30.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
	
	@CreatedBy
	@Column(name = "createby", columnDefinition = "nvarchar(89) DEFAULT(N'ADMIN')")
	private String createBy;
	
	@CreatedDate
	@Column(name = "createdate", columnDefinition = "datetime DEFAULT(GETDATE())")
	private Date createDate;
	
	@LastModifiedBy
	@Column(name = "modifiesby", columnDefinition = "nvarchar(89) DEFAULT(N'ADMIN')")
	private String modifiesBy;
	
	@LastModifiedDate
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
