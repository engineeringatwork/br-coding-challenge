package com.bottlerocket.coding.challenge.factories;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.bottlerocket.coding.challenge.domain.AdvertisementAsset;
import com.bottlerocket.coding.challenge.domain.MediaAsset;
import com.bottlerocket.coding.challenge.domain.VideoAsset;
import com.bottlerocket.coding.challenge.repositories.AdvertisementAssetRepository;
import com.bottlerocket.coding.challenge.repositories.VideoAssetRepository;
import com.bottlerocket.coding.challenge.response.view.models.AdvertisementAssetViewModel;
import com.bottlerocket.coding.challenge.response.view.models.ImageAssetViewModel;
import com.bottlerocket.coding.challenge.response.view.models.MediaAssetViewModel;
import com.bottlerocket.coding.challenge.response.view.models.VideoAssetViewModel;

@Component
public class ShowAssetFactory implements MediaAssetFactory
{	
	@Autowired
	AdvertisementAssetRepository advertisementAssetRepository_preInject;

	@Autowired
	VideoAssetRepository videoAssetRepository_preInject;

	@Value("${media.type.image.alias}")
	private String IMAGE_CONTENT_ALIAS_preInject;
	
	@Value("${media.type.video.alias}")
	private String VIDEO_CONTENT_ALIAS_preInject;
	
	@Value("${media.type.advertisement.alias}")
	private String ADVERTISEMENT_CONTENT_ALIAS_preInject;

	private static AdvertisementAssetRepository advertisementAssetRepository;
	
	private static VideoAssetRepository videoAssetRepository;
	
	private static String IMAGE_CONTENT_ALIAS;
	
	private static String VIDEO_CONTENT_ALIAS;
	
	private static String ADVERTISEMENT_CONTENT_ALIAS;
	
	@PostConstruct
	public void init() 
	{
		advertisementAssetRepository = advertisementAssetRepository_preInject;
		videoAssetRepository = videoAssetRepository_preInject;
		IMAGE_CONTENT_ALIAS = IMAGE_CONTENT_ALIAS_preInject;
		VIDEO_CONTENT_ALIAS = VIDEO_CONTENT_ALIAS_preInject;
		ADVERTISEMENT_CONTENT_ALIAS = ADVERTISEMENT_CONTENT_ALIAS_preInject;
	}
	
	@Override
	public List<MediaAssetViewModel> generateAssetViewModelsFromBusinessObjects(List<MediaAsset> mediaAssets) 
	{
		List<MediaAssetViewModel> mediaAssetViewModels = new ArrayList<MediaAssetViewModel>();
		
		for(MediaAsset mediaAsset : mediaAssets)
		{
			mediaAssetViewModels.add(transformMediaAssetToViewModel(mediaAsset));
		}
		
		Collections.sort(mediaAssetViewModels);

		return mediaAssetViewModels;
	}
	
	
	/**
	 * Method that transforms a media asset business object to view model representation
	 * 
	 * @param mediaAsset - business object
	 * 
	 * @return mediaAssetViewModel - view model
	 */
	public static MediaAssetViewModel transformMediaAssetToViewModel(MediaAsset mediaAsset) 
	{		
		MediaAssetViewModel mediaAssetViewModel = null;
		
		String mediaType = mediaAsset.getMediaType().getName();
		
		if(mediaType !=null)
		{
			if(IMAGE_CONTENT_ALIAS.equalsIgnoreCase(mediaType))
			{
				mediaAssetViewModel = generateImageMediaAssetToViewModel(mediaAsset);
			}
			else if(VIDEO_CONTENT_ALIAS.equalsIgnoreCase(mediaType))
			{
				mediaAssetViewModel = generateVideoMediaAssetToViewModel(mediaAsset);
			}
			else if(ADVERTISEMENT_CONTENT_ALIAS.equalsIgnoreCase(mediaType))
			{
				mediaAssetViewModel = generateAdvertisementMediaAssetToViewModel(mediaAsset);
			}
		}
		

		return mediaAssetViewModel;
	}
	
	/**
	 * Method to generate the core media asset information for a media asset
	 * 
	 * @param mediaAsset - business object
	 * @param mediaAssetViewModel - a view model object that inherits from media asset view model
	 * 
	 * @return mediaAssetViewModel - media asset view model
	 */
	private static MediaAssetViewModel generateMediaAssetInformation(MediaAsset mediaAsset, MediaAssetViewModel mediaAssetViewModel)
	{
		mediaAssetViewModel.setId(mediaAsset.getId());
		mediaAssetViewModel.setDateCreated(mediaAsset.getDateCreated().getTimeInMillis());
		mediaAssetViewModel.setDateUpdated(mediaAsset.getDateUpdated().getTimeInMillis());
		mediaAssetViewModel.setVersion(mediaAsset.getVersion());

		mediaAssetViewModel.setName(mediaAsset.getName());
		mediaAssetViewModel.setMediaType(mediaAsset.getMediaType().getName());
		mediaAssetViewModel.setUrl(mediaAsset.getUrl());
		mediaAssetViewModel.setDateExpiredInMillis(mediaAsset.getDateExpired().getTimeInMillis());
		
		return mediaAssetViewModel;
	}
	
	/**
	 * Method to generate a specialized image media asset object
	 * 
	 * @param mediaAsset - media asset business object
	 * 
	 * @return imageMediaAssetViewModel - image media asset view model
	 */
	private static ImageAssetViewModel generateImageMediaAssetToViewModel(MediaAsset mediaAsset)
	{
		ImageAssetViewModel imageMediaAssetViewModel = new ImageAssetViewModel();
		
		imageMediaAssetViewModel = (ImageAssetViewModel) generateMediaAssetInformation(mediaAsset, imageMediaAssetViewModel);
		
		return imageMediaAssetViewModel;

	}
	
	/**
	 * Method to generate a specialized video media asset object
	 * 
	 * @param mediaAsset - media asset business object
	 * 
	 * @return videoMediaAssetViewModel - video media asset view model
	 */
	private static VideoAssetViewModel generateVideoMediaAssetToViewModel(MediaAsset mediaAsset)
	{
		VideoAssetViewModel videoMediaAssetViewModel = new VideoAssetViewModel();
		
		Optional<VideoAsset> additionalVideoDetailResults = videoAssetRepository.findById(mediaAsset.getId());
		
		videoMediaAssetViewModel = (VideoAssetViewModel) generateMediaAssetInformation(mediaAsset, videoMediaAssetViewModel);

		if(additionalVideoDetailResults.isPresent())
		{
			VideoAsset additionalVideoDetails = additionalVideoDetailResults.get();
			
			videoMediaAssetViewModel.setVideoType(additionalVideoDetails.getVideoType().getName());
		}
		
		return videoMediaAssetViewModel;
	}
	
	/**
	 * Method to generate a specialized advertisement media asset object
	 * 
	 * @param mediaAsset - media asset business object
	 * 
	 * @return advertisementAssetViewModel - advertisement media asset view model
	 */
	private static AdvertisementAssetViewModel generateAdvertisementMediaAssetToViewModel(MediaAsset mediaAsset)
	{
		AdvertisementAssetViewModel advertisementAssetViewModel = new AdvertisementAssetViewModel();
		
		Optional<AdvertisementAsset> additionalAdvertisementDetailResults = advertisementAssetRepository.findById(mediaAsset.getId());
		
		advertisementAssetViewModel = (AdvertisementAssetViewModel) generateMediaAssetInformation(mediaAsset, advertisementAssetViewModel);

		if(additionalAdvertisementDetailResults.isPresent())
		{
			AdvertisementAsset additionalAdvertisementDetails = additionalAdvertisementDetailResults.get();
			
			advertisementAssetViewModel.setProductDescription(additionalAdvertisementDetails.getProductDescription());
		}
		
		return advertisementAssetViewModel;
	}
}
