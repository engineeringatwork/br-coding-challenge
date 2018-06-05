package com.bottlerocket.coding.challenge.adapters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.bottlerocket.coding.challenge.domain.LookupReference;
import com.bottlerocket.coding.challenge.domain.LookupType;
import com.bottlerocket.coding.challenge.response.view.models.LookupReferenceViewModel;
import com.bottlerocket.coding.challenge.response.view.models.LookupTypeViewModel;


public class LookupAdapter 
{

	/**
	 * Main method that performs the transformation logic for lookup type
	 * 
	 * @param lookupType - lookup type
	 * 
	 * @return result - type view model for result wrapper
	 */
	public static LookupTypeViewModel transformLookupTypeToViewModel(
			LookupType lookupType) {
		List<LookupReferenceViewModel> referenceViewModels = new ArrayList<LookupReferenceViewModel>();

		LookupTypeViewModel lookupTypeViewModel = new LookupTypeViewModel();

		lookupTypeViewModel.setId(lookupType.getId());
		lookupTypeViewModel.setDateCreated(lookupType.getDateCreated().getTimeInMillis());
		lookupTypeViewModel.setDateUpdated(lookupType.getDateUpdated().getTimeInMillis());
		lookupTypeViewModel.setVersion(lookupType.getVersion());
		lookupTypeViewModel.setName(lookupType.getName());
		lookupTypeViewModel.setDescription(lookupType.getDescription());
		lookupTypeViewModel.setIsActive(lookupType.getIsActive());

		if (lookupType.getLookupReferences() != null) {
			List<LookupReference> lookupReferences = new ArrayList<LookupReference>(
					lookupType.getLookupReferences());

			Collections.sort(lookupReferences);

			for (LookupReference lookupReference : lookupReferences) {
				referenceViewModels
						.add(transformLookupReferenceToViewModel(lookupReference));
			}
		}

		lookupTypeViewModel.setOptions(referenceViewModels);

		return lookupTypeViewModel;
	}

	/**
	 * Applies the transformation against a list of lookup references to a list of lookup
	 * reference view models
	 * 
	 * @param lookupReferences - list of lookup references
	 * 
	 * @return viewModels - list of lookup reference view models
	 */
	public static List<LookupReferenceViewModel> transformLookupReferencesToViewModel(
			List<LookupReference> lookupReferences) {
		List<LookupReferenceViewModel> viewModels = new ArrayList<LookupReferenceViewModel>();

		if (lookupReferences != null) {
			Collections.sort(lookupReferences);
		
			for (LookupReference lookupReference : lookupReferences) {
				viewModels.add(transformLookupReferenceToViewModel(lookupReference));
			}
		}

		return viewModels;
	}

	/**
	 * Main method that performs the transformation logic for lookup data
	 * 
	 * @param lookupReference - lookup data database record
	 * 
	 * @return viewModel - view model representation of the lookup data provided
	 */
	public static LookupReferenceViewModel transformLookupReferenceToViewModel(
			LookupReference lookupReference) {
		LookupReferenceViewModel lookupReferenceViewModel = new LookupReferenceViewModel();

		lookupReferenceViewModel.setId(lookupReference.getId());
		lookupReferenceViewModel.setDateCreated(lookupReference.getDateCreated().getTimeInMillis());
		lookupReferenceViewModel.setDateUpdated(lookupReference.getDateUpdated().getTimeInMillis());
		lookupReferenceViewModel.setVersion(lookupReference.getVersion());
		lookupReferenceViewModel.setName(lookupReference.getName());
		lookupReferenceViewModel.setDescription(lookupReference.getDescription());
		
		return lookupReferenceViewModel;
	}
}
