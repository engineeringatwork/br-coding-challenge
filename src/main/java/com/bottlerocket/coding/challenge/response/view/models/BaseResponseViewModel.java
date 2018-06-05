package com.bottlerocket.coding.challenge.response.view.models;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Overall Information Related to any object")
public abstract class BaseResponseViewModel implements Serializable
{
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "Internal identifier associated with the object", required = false)
	private String id;

	@ApiModelProperty(value = "Date this object was created", required = false)
	private Long dateCreated;
	
	@ApiModelProperty(value = "Last time this object was updated", required = false)
	private Long dateUpdated;
	
	@ApiModelProperty(value = "Version of the object", required = false)
	private Integer version;
	
	public BaseResponseViewModel() 
	{
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Long dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Long getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Long dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) 
	{
		this.version = version;
	}
	
	
}
