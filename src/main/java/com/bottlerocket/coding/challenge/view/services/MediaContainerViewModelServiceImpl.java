package com.bottlerocket.coding.challenge.view.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bottlerocket.coding.challenge.adapters.MediaContainerAdapter;
import com.bottlerocket.coding.challenge.database.services.MediaContainerDatabaseService;
import com.bottlerocket.coding.challenge.domain.MediaAsset;
import com.bottlerocket.coding.challenge.domain.MediaContainer;
import com.bottlerocket.coding.challenge.response.view.models.MediaAssetResultWrapper;
import com.bottlerocket.coding.challenge.response.view.models.MediaContainerResultWrapper;
import com.bottlerocket.coding.challenge.response.view.models.MediaContainerViewModel;

@Service
public class MediaContainerViewModelServiceImpl implements MediaContainerViewModelService
{
	@Autowired
	MediaContainerDatabaseService mediaContainerDatabaseService;

	@Override
	public MediaContainerViewModel getMediaContainerByID(String mediaContainerId) 
	{
		Optional<MediaContainer> mediaContainer = mediaContainerDatabaseService.getMediaContainerByID(mediaContainerId);

		return mediaContainer.isPresent() ? MediaContainerAdapter.transformMediaContainerToViewModel(mediaContainer.get()) : null;
	}

	@Override
	public MediaContainerResultWrapper getAllMediaContainersByContainerType(String containerTypeName) 
	{
		List<MediaContainer> mediaContainers = mediaContainerDatabaseService.getAllMediaContainersByContainerType(containerTypeName);

		MediaContainerResultWrapper resultViewModel = MediaContainerAdapter.transformMediaContainersToResultViewModel(mediaContainers);
		
		return resultViewModel;
	}

	@Override
	public MediaAssetResultWrapper getAllMediaAssetsForContainer(String mediaContainerId) 
	{
		List<MediaAsset> mediaAssets = mediaContainerDatabaseService.getAllMediaAssetsForContainer(mediaContainerId);

		MediaAssetResultWrapper resultViewModel = MediaContainerAdapter.transformMediaAssetsToResultViewModel(mediaAssets);

		return resultViewModel;
	}

}
