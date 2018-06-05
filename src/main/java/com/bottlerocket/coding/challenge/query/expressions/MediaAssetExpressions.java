package com.bottlerocket.coding.challenge.query.expressions;

import com.bottlerocket.coding.challenge.domain.QMediaAsset;
import com.querydsl.core.types.dsl.BooleanExpression;

public class MediaAssetExpressions 
{

	 /**
	   * Creates a expression used to find media assets associated to the
	   * parent media container identifier
	   *
	   * @param mediaContainerId
	   *        - media container identifier
	   * 
	   * @return Media Asset Reference Expression
	   */
	  public static BooleanExpression hasParentContainer(
	      final String mediaContainerId)
	  {
	    BooleanExpression hasParentContainer = null;

	    QMediaAsset mediaAsset = QMediaAsset.mediaAsset;

	    if (mediaContainerId != null)
	    {
	      hasParentContainer = mediaAsset.associatedContainer.id.equalsIgnoreCase(mediaContainerId);
	    }
	    else
	    {
	      hasParentContainer = mediaAsset.isNotNull();
	    }

	    return hasParentContainer;
	  }
	  
}
