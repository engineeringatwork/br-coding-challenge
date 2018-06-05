package com.bottlerocket.coding.challenge.adapters;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.bottlerocket.coding.challenge.domain.MediaAsset;
import com.bottlerocket.coding.challenge.domain.MediaContainer;
import com.bottlerocket.coding.challenge.factories.MediaAssetFactory;
import com.bottlerocket.coding.challenge.response.view.models.MediaAssetResultWrapper;
import com.bottlerocket.coding.challenge.response.view.models.MediaContainerResultWrapper;
import com.bottlerocket.coding.challenge.response.view.models.MediaContainerViewModel;

@Component
public class MediaContainerAdapter 
{
	@Autowired
	private MediaAssetFactory mediaAssetFactory_preinject;

	private static MediaAssetFactory mediaAssetFactory;

	@PostConstruct
	public void init() 
	{
		mediaAssetFactory = mediaAssetFactory_preinject;
	}
	
	/**
	 * Method that transforms a media container business object to view model representation
	 * 
	 * @param mediaContainer - business object
	 * 
	 * @return mediaContainerViewModel - view model
	 */
	public static MediaContainerViewModel transformMediaContainerToViewModel(MediaContainer mediaContainer) 
	{
		MediaContainerViewModel mediaContainerViewModel = new MediaContainerViewModel();
		
		mediaContainerViewModel.setId(mediaContainer.getId());
		mediaContainerViewModel.setDateCreated(mediaContainer.getDateCreated().getTimeInMillis());
		mediaContainerViewModel.setDateUpdated(mediaContainer.getDateCreated().getTimeInMillis());
		mediaContainerViewModel.setVersion(mediaContainer.getVersion());
		mediaContainerViewModel.setContainerType(mediaContainer.getContainerType().getName());
		mediaContainerViewModel.setName(mediaContainer.getName());
		mediaContainerViewModel.setDescription(mediaContainer.getDescription());
		
		if(mediaContainer.getAssets() !=null && !mediaContainer.getAssets().isEmpty())
		{
			List<MediaAsset> mediaAssets = new ArrayList<MediaAsset>(mediaContainer.getAssets());
			
			mediaContainerViewModel.setAssets(mediaAssetFactory.generateAssetViewModelsFromBusinessObjects(mediaAssets));
		}
				
		return mediaContainerViewModel;
	}

	/**
	 * Method that transforms a collection of media container business object to view model representation
	 * 
	 * @param mediaContainers
	 * 
	 * @return resultWrapper - the media container result wrapper that contains a collection of media containers
	 */
	public static MediaContainerResultWrapper transformMediaContainersToResultViewModel(List<MediaContainer> mediaContainers) 
	{
		MediaContainerResultWrapper resultWrapper = new MediaContainerResultWrapper();
		
		List<MediaContainerViewModel> mediaContainerViewModels = new ArrayList<MediaContainerViewModel>();
		
		mediaContainers.forEach(new Consumer<MediaContainer>() {

			public void accept(MediaContainer mediaContainer) 
			{
				mediaContainerViewModels.add(transformMediaContainerToViewModel(mediaContainer));
			}
		});
		
		resultWrapper.setMediaContainers(mediaContainerViewModels);
				
		return resultWrapper;
	}

	/**
	 * Method that transforms a collection of media asset business objects to view model representation
	 * 
	 * @param mediaAssets - collection of media asset business objects
	 * 
	 * @return resultWrapper - the media asset result wrapper that contains a collection of media assets
	 */
	public static MediaAssetResultWrapper transformMediaAssetsToResultViewModel(List<MediaAsset> mediaAssets) 
	{
		MediaAssetResultWrapper resultWrapper = new MediaAssetResultWrapper();

		resultWrapper.setMediaAssets(mediaAssetFactory.generateAssetViewModelsFromBusinessObjects(mediaAssets));
		
		return resultWrapper;
	}

	
	
}
