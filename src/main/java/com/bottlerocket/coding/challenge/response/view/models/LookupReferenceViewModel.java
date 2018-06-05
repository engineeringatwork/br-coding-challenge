package com.bottlerocket.coding.challenge.response.view.models;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Lookup Reference View Model to capture lookup data information")
public class LookupReferenceViewModel extends BaseResponseViewModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "Name of lookup reference", required = false)
	private String name;

	@ApiModelProperty(value = "Description of lookup reference", required = false)
	private String description;

	public LookupReferenceViewModel() {
		super();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
}
