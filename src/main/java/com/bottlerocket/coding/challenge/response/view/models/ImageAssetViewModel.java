package com.bottlerocket.coding.challenge.response.view.models;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;

@ApiModel("View model to capture specialized image media information")
public class ImageAssetViewModel extends MediaAssetViewModel implements Serializable
{
	private static final long serialVersionUID = 1L;

	public ImageAssetViewModel()
	{
		super();
	}
}
