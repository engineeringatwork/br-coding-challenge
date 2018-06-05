
package com.bottlerocket.coding.challenge.response.view.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Base View Model that all media inherit from")
public abstract class MediaAssetViewModel extends BaseResponseViewModel implements Comparable<MediaAssetViewModel>
{
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "Name of Media Asset", required = true)
	private String name;

	@ApiModelProperty(value = "Type identifier of Media Asset", required = true)
	private String mediaType;

	@ApiModelProperty(value = "URL Address to retrieve Media Asset Content", required = true)
	private String url;
	
	@ApiModelProperty(value = "Expiration Date of Media Asset Content", required = true)
	private Long dateExpiredInMillis;
	
	public MediaAssetViewModel() 
	{
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getDateExpiredInMillis() {
		return dateExpiredInMillis;
	}

	public void setDateExpiredInMillis(Long dateExpiredInMillis) {
		this.dateExpiredInMillis = dateExpiredInMillis;
	}
	
	@Override
	public int compareTo(MediaAssetViewModel otherMediaAssetViewModel)
	{
		return (this.mediaType).compareTo(otherMediaAssetViewModel.mediaType);
	}
	
}