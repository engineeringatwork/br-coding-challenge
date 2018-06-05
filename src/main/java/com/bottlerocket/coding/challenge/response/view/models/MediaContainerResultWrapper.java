package com.bottlerocket.coding.challenge.response.view.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("View Model to capture a collection of media containers")
public class MediaContainerResultWrapper implements Serializable
{
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "List of associated media containers", required = true)
	private List<MediaContainerViewModel> mediaContainers = new ArrayList<MediaContainerViewModel>();

	public MediaContainerResultWrapper()
	{
		super();
	}

	public List<MediaContainerViewModel> getMediaContainers() {
		return mediaContainers;
	}

	public void setMediaContainers(List<MediaContainerViewModel> mediaContainers) {
		this.mediaContainers = mediaContainers;
	}	
}
