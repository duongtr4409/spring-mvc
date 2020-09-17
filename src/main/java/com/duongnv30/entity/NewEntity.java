package com.duongnv30.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_new")
public class NewEntity extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "title", columnDefinition = "nvarchar(255)", nullable = false)
	private String title;

	@Column(name = "thumbnail", columnDefinition = "nvarchar(255)")
	private String thumbnail;

	@Column(name = "shortdescription", columnDefinition = "nvarchar(max) default('')", nullable = false)
	private String shortDescription;

	@Column(name = "content", columnDefinition = "nvarchar(max)", nullable = false)
	private String content;

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
