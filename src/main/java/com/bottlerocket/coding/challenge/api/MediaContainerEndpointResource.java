package com.bottlerocket.coding.challenge.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bottlerocket.coding.challenge.response.view.models.MediaAssetResultWrapper;
import com.bottlerocket.coding.challenge.response.view.models.MediaContainerResultWrapper;
import com.bottlerocket.coding.challenge.response.view.models.MediaContainerViewModel;
import com.bottlerocket.coding.challenge.view.services.MediaContainerViewModelService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v1/bottlerocket/media/containers")
public class MediaContainerEndpointResource
{
  @Autowired
  MediaContainerViewModelService mediaContainerViewModelService;
  
  @GetMapping("/{id}")
  @ApiOperation(value = "Retrieves a media container by its internal identifier", notes = "Returns the media container that has the internal identifier provided")
  public MediaContainerViewModel getMediaContainerById(@PathVariable("id") String mediaContainerId)
  {
    return mediaContainerViewModelService.getMediaContainerByID(mediaContainerId);
  }

  @GetMapping("/types/{containerType}")
  @ApiOperation(value = "Returns a list of all media container instances given a container type", notes = "Returns a list of all media container instances given a container type")
  public MediaContainerResultWrapper getAllMediaContainersByType(
      @PathVariable("containerType") String containerType)
  {
	return mediaContainerViewModelService.getAllMediaContainersByContainerType(containerType);
  }
  
  @GetMapping("/{id}/assets")
  @ApiOperation(value = "Retrieves a collection of media assets associated with the media container provided", notes = "Retrieves a collection of media assets associated with the media container provided")
  public MediaAssetResultWrapper getAllMediaAssetsByContainerId(@PathVariable("id") String mediaContainerId)
  {
    return mediaContainerViewModelService.getAllMediaAssetsForContainer(mediaContainerId);
  }
}
