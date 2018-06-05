package com.bottlerocket.coding.challenge.api;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bottlerocket.coding.challenge.response.view.models.LookupReferenceViewModel;
import com.bottlerocket.coding.challenge.response.view.models.LookupTypeViewModel;
import com.bottlerocket.coding.challenge.view.services.LookupViewModelService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v1/bottlerocket/lookups")
public class LookupEndpointResource
{
  @Autowired
  LookupViewModelService lookupViewModelService;

  @GetMapping("/types/{id}")
  @ApiOperation(value = "Retrieves a template lookup type by its internal identifier", notes = "Returns the template lookup type that has the internal identifier provided")
  public LookupTypeViewModel getLookupTypeById(@PathVariable("id") String lookupTypeId)
  {
    return lookupViewModelService.getTypeByID(lookupTypeId);
  }

  @GetMapping("/types/{lookupTypeName}/references")
  @ApiOperation(value = "Returns a list of all lookup reference view models with the given lookup type name", notes = "Returns a list of all lookup reference view models with the given lookup type name")
  public Collection<LookupReferenceViewModel> getAllReferencesByLookupTypeName(
      @PathVariable("lookupTypeName") String lookupTypeName)
  {
    return lookupViewModelService.getAllReferencesByLookupTypeName(lookupTypeName);
  }

}
