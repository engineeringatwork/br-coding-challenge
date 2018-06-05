package com.bottlerocket.coding.challenge.query.expressions;

import com.bottlerocket.coding.challenge.domain.QLookupReference;
import com.querydsl.core.types.dsl.BooleanExpression;


/**
 * Defines a library of filter criteria expressions that can be used to filter
 * lookup reference data from the database. They can also be chained together
 * if needed for more advanced filtering needs
 */
public class LookupReferenceExpressions
{

  /**
   * Creates a expression used to find lookup reference associated to the
   * parent lookup type name
   *
   * @param lookupTypeName
   *        - lookup type name
   * 
   * @return Lookup Reference Expression
   */
  public static BooleanExpression hasLookupTypeName(
      final String lookupTypeName)
  {
    BooleanExpression hasLookupTypeName = null;

    QLookupReference lookupReference = QLookupReference.lookupReference;

    if (lookupTypeName != null)
    {
      hasLookupTypeName = lookupReference.lookupType.name.equalsIgnoreCase(lookupTypeName);
    }
    else
    {
      hasLookupTypeName = lookupReference.isNotNull();
    }

    return hasLookupTypeName;
  }
  
  /**
   * Creates a expression used to find lookup reference with a set name
   *
   * @param lookupReferenceName - lookup reference name
   * 
   * @return Lookup Reference Expression
   */
  public static BooleanExpression hasLookupReferenceName(
      final String lookupReferenceName)
  {
    BooleanExpression hasLookupReferenceName = null;

    QLookupReference lookupReference = QLookupReference.lookupReference;

    if (lookupReferenceName != null)
    {
    	hasLookupReferenceName = lookupReference.name.equalsIgnoreCase(lookupReferenceName);
    }
    else
    {
    	hasLookupReferenceName = lookupReference.isNotNull();
    }

    return hasLookupReferenceName;
  }
}
