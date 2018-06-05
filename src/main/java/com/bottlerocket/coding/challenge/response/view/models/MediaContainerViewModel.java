package com.bottlerocket.coding.challenge.response.view.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("View Model to capture the media container information")
public class MediaContainerViewModel extends BaseResponseViewModel implements Serializable
{
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "Name of media container", required = true)
	private String name;

	@ApiModelProperty(value = "Description of media container", required = true)
	private String description;

	@ApiModelProperty(value = "The type of media container this is (e.g Show, Movie, Album)", required = true)
	private String containerType;

	@ApiModelProperty(value = "List of associated media assets (e.g Video, Advertisement, Images)", required = true)
	private List<MediaAssetViewModel> assets = new ArrayList<MediaAssetViewModel>();

	public MediaContainerViewModel()
	{
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContainerType() {
		return containerType;
	}

	public void setContainerType(String containerType) {
		this.containerType = containerType;
	}

	public List<MediaAssetViewModel> getAssets() {
		return assets;
	}

	public void setAssets(List<MediaAssetViewModel> assets) {
		this.assets = assets;
	}
}
