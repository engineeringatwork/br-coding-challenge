package com.bottlerocket.coding.challenge.factories;

import java.util.List;
import com.bottlerocket.coding.challenge.domain.MediaAsset;
import com.bottlerocket.coding.challenge.response.view.models.MediaAssetViewModel;

public interface MediaAssetFactory 
{	
	/** Factory method to generate a collection of media asset view models based on a collection of media asset business objects  */
	public abstract List<MediaAssetViewModel> generateAssetViewModelsFromBusinessObjects(List<MediaAsset> mediaAssets);

}
