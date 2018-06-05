package com.bottlerocket.coding.challenge.response.view.models;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("View model to capture specialized video media information")
public class VideoAssetViewModel extends MediaAssetViewModel implements Serializable
{
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "Type of video", required = true)
	private String videoType;

	public VideoAssetViewModel()
	{
		super();
	}

	public String getVideoType() {
		return videoType;
	}

	public void setVideoType(String videoType) {
		this.videoType = videoType;
	}
}
