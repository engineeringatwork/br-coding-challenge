package com.bottlerocket.coding.challenge.database.services;

import java.util.Collection;
import java.util.Optional;

import com.bottlerocket.coding.challenge.domain.LookupReference;
import com.bottlerocket.coding.challenge.domain.LookupType;


/** This database service is responsible for supporting LookupType and its associated LookupReference business objects */
public interface LookupDatabaseService
{
	/** Gets a lookup type record based on the internal identifier provided */
	public abstract Optional<LookupType> getTypeByID(String lookupTypeId);

	/** Gets a lookup reference record based on the lookup type name and reference provided */
	public abstract Optional<LookupReference> getReferenceByNameAndParentType(String lookupTypeName, String lookupReferenceName);
	
	/** Gets the list of lookup references based on the parent lookup type provided */
	public abstract Collection<LookupReference> getAllReferencesByLookupTypeName(String lookupTypeName);
}
