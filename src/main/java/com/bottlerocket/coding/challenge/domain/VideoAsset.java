
package com.bottlerocket.coding.challenge.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BR_MEDIA_ASSET_VIDEO")
public class VideoAsset extends MediaAsset implements Serializable
{
	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = LookupReference.class)
	@JoinColumn(nullable = false, name = "TYPE_ID")
	private LookupReference videoType;

	public VideoAsset()
	{
		super();
	}

	public LookupReference getVideoType() {
		return videoType;
	}

	public void setVideoType(LookupReference videoType) {
		this.videoType = videoType;
	}
}