package com.bottlerocket.coding.challenge.query.expressions;

import com.bottlerocket.coding.challenge.domain.QMediaContainer;
import com.querydsl.core.types.dsl.BooleanExpression;

public class MediaContainerExpressions 
{

	 /**
	   * Creates a expression used to find media containers based on their type
	   *
	   * @param containerTypeName
	   *        - media container type name
	   * 
	   * @return Media Container Reference Expression
	   */
	  public static BooleanExpression hasContainerType(
	      final String containerTypeName)
	  {
	    BooleanExpression hasContainerType = null;

	    QMediaContainer mediaContainer = QMediaContainer.mediaContainer;

	    if (containerTypeName != null)
	    {
	    	hasContainerType = mediaContainer.containerType.name.equalsIgnoreCase(containerTypeName);
	    }
	    else
	    {
	    	hasContainerType = mediaContainer.isNotNull();
	    }

	    return hasContainerType;
	  }
}
