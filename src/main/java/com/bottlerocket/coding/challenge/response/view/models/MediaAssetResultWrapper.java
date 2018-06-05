package com.bottlerocket.coding.challenge.response.view.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("View Model to capture a collection of media assets")
public class MediaAssetResultWrapper implements Serializable
{
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "List of associated media assets", required = true)
	private List<MediaAssetViewModel> mediaAssets = new ArrayList<MediaAssetViewModel>();

	public MediaAssetResultWrapper()
	{
		super();
	}

	public List<MediaAssetViewModel> getMediaAssets() {
		return mediaAssets;
	}

	public void setMediaAssets(List<MediaAssetViewModel> mediaAssets) {
		this.mediaAssets = mediaAssets;
	}
	
	

}
