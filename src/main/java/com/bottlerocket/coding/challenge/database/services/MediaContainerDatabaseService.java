package com.bottlerocket.coding.challenge.database.services;

import java.util.List;
import java.util.Optional;

import com.bottlerocket.coding.challenge.domain.MediaAsset;
import com.bottlerocket.coding.challenge.domain.MediaContainer;


/** This database service is responsible for supporting Media Containers and Media Assets business objects */
public interface MediaContainerDatabaseService
{
	/** Gets a media container record based on the internal identifier provided */
	public abstract Optional<MediaContainer> getMediaContainerByID(String mediaContainerId);

	/** Gets a collection of media container record(s) based on the container type name provided */
	public abstract List<MediaContainer> getAllMediaContainersByContainerType(String containerTypeName);
	
	/** Gets a collection of media asset record(s) based on the associated media container id */
	public abstract List<MediaAsset> getAllMediaAssetsForContainer(String mediaContainerId);
}
