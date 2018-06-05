package com.bottlerocket.coding.challenge.response.view.models;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("View model to capture specialized advertisement media information")
public class AdvertisementAssetViewModel extends MediaAssetViewModel implements Serializable
{
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "Description of product that video is for", required = true)
	private String productDescription;

	public AdvertisementAssetViewModel()
	{
		super();
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	
}
