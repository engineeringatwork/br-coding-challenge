package com.bottlerocket.coding.challenge.view.services;

import java.util.Collection;

import com.bottlerocket.coding.challenge.response.view.models.LookupReferenceViewModel;
import com.bottlerocket.coding.challenge.response.view.models.LookupTypeViewModel;


public interface LookupViewModelService
{
  /** Gets a lookup type view model based on the internal identifier provided */
  public abstract LookupTypeViewModel getTypeByID(String lookupTypeId);

  /** Gets a list of lookup reference view models by the lookup type name provided */
  public abstract Collection<LookupReferenceViewModel> getAllReferencesByLookupTypeName(String lookupTypeName);
}
