package com.bottlerocket.coding.challenge.database.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bottlerocket.coding.challenge.domain.MediaAsset;
import com.bottlerocket.coding.challenge.domain.MediaContainer;
import com.bottlerocket.coding.challenge.query.expressions.MediaAssetExpressions;
import com.bottlerocket.coding.challenge.query.expressions.MediaContainerExpressions;
import com.bottlerocket.coding.challenge.repositories.MediaAssetRepository;
import com.bottlerocket.coding.challenge.repositories.MediaContainerRepository;



@Service
@Transactional(readOnly = true)
public class MediaContainerDatabaseServiceImpl implements MediaContainerDatabaseService
{
	private static final Logger LOGGER = LoggerFactory
			.getLogger(MediaContainerDatabaseServiceImpl.class);

	@Autowired
	MediaContainerRepository mediaContainerRepository;

	@Autowired
	MediaAssetRepository mediaAssetRepository;

	@Override
	public Optional<MediaContainer> getMediaContainerByID(String mediaContainerId)
	{
		LOGGER.debug(
				"MediaContainerDatabaseServiceImpl - getMediaContainerByID() - Searching media container repository with id of "
						+ mediaContainerId);

		return mediaContainerRepository.findById(mediaContainerId);
	}

	
	@Override
	public List<MediaContainer> getAllMediaContainersByContainerType(String containerTypeName) 
	{
		LOGGER.debug(
				"MediaContainerDatabaseServiceImpl - getAllMediaContainersByContainerType() - Searching media container repository for media containers that have container type of "
						+ containerTypeName);

		List<MediaContainer> mediaContainers = (List<MediaContainer>) mediaContainerRepository.findAll(MediaContainerExpressions.hasContainerType(containerTypeName));
	
		LOGGER.debug(
				"MediaContainerDatabaseServiceImpl - getAllMediaContainersByContainerType() - Found "
						+ mediaContainers.size() + " media containers that match container type defined");
		
		return mediaContainers;
	}

	@Override
	public List<MediaAsset> getAllMediaAssetsForContainer(String mediaContainerId) 
	{
		LOGGER.debug(
				"MediaContainerDatabaseServiceImpl - getAllMediaAssetsForContainer() - Searching media asset repository for media assets that have parent container id of "
						+ mediaContainerId);

		List<MediaAsset> mediaAssets = (List<MediaAsset>) mediaAssetRepository.findAll(MediaAssetExpressions.hasParentContainer(mediaContainerId));

		LOGGER.debug(
				"MediaContainerDatabaseServiceImpl - getAllMediaAssetsForContainer() - Found "
						+ mediaAssets.size() + " media assets associated with the media container");
		
		return mediaAssets;
	}
}
