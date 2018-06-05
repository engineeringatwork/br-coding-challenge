package com.bottlerocket.coding.challenge.view.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bottlerocket.coding.challenge.adapters.LookupAdapter;
import com.bottlerocket.coding.challenge.database.services.LookupDatabaseService;
import com.bottlerocket.coding.challenge.domain.LookupReference;
import com.bottlerocket.coding.challenge.domain.LookupType;
import com.bottlerocket.coding.challenge.response.view.models.LookupReferenceViewModel;
import com.bottlerocket.coding.challenge.response.view.models.LookupTypeViewModel;

@Service
public class LookupViewModelServiceImpl implements LookupViewModelService
{
  @Autowired
  LookupDatabaseService lookupDatabaseService;

  @Override
  public LookupTypeViewModel getTypeByID(String lookupTypeId)
  {
    Optional<LookupType> lookupType = lookupDatabaseService.getTypeByID(lookupTypeId);

    return lookupType.isPresent() ? LookupAdapter.transformLookupTypeToViewModel(lookupType.get()) : null;
  }

  @Override
  public List<LookupReferenceViewModel> getAllReferencesByLookupTypeName(String lookupTypeName)
  {
    List<LookupReference> lookupReferences = (List<LookupReference>) lookupDatabaseService.getAllReferencesByLookupTypeName(lookupTypeName);

    return LookupAdapter.transformLookupReferencesToViewModel(lookupReferences);
  }

}
