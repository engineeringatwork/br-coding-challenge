
package com.bottlerocket.coding.challenge.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "BR_MEDIA_ASSET_ADVERTISEMENT")
public class AdvertisementAsset extends MediaAsset implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Column(name = "PRODUCT_DESCRIPTION", length = 255, nullable = false)
	private String productDescription;

	public AdvertisementAsset()
	{
		super();
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) 
	{
		this.productDescription = productDescription;
	}
}