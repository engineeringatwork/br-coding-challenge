package com.bottlerocket.coding.challenge.view.services;

import com.bottlerocket.coding.challenge.response.view.models.MediaAssetResultWrapper;
import com.bottlerocket.coding.challenge.response.view.models.MediaContainerResultWrapper;
import com.bottlerocket.coding.challenge.response.view.models.MediaContainerViewModel;


/** This view service is responsible for supporting Media Containers and Media Assets view models */
public interface MediaContainerViewModelService
{
	/** Gets a media container record based on the internal identifier provided */
	public abstract MediaContainerViewModel getMediaContainerByID(String mediaContainerId);

	/** Gets a collection of media container record(s) based on the container type name provided */
	public abstract MediaContainerResultWrapper getAllMediaContainersByContainerType(String containerTypeName);
	
	/** Gets a collection of media asset record(s) based on the associated media container id */
	public abstract MediaAssetResultWrapper getAllMediaAssetsForContainer(String mediaContainerId);
}
