package com.bottlerocket.coding.challenge.database.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bottlerocket.coding.challenge.domain.LookupReference;
import com.bottlerocket.coding.challenge.domain.LookupType;
import com.bottlerocket.coding.challenge.query.expressions.LookupReferenceExpressions;
import com.bottlerocket.coding.challenge.repositories.LookupReferenceRepository;
import com.bottlerocket.coding.challenge.repositories.LookupTypeRepository;


@Service
@Transactional(readOnly = true)
public class LookupDatabaseServiceImpl implements LookupDatabaseService
{
	private static final Logger LOGGER = LoggerFactory
			.getLogger(LookupDatabaseServiceImpl.class);

	@Autowired
	LookupTypeRepository lookupTypeRepository;

	@Autowired
	LookupReferenceRepository lookupReferenceRepository;

	@Override
	public Optional<LookupType> getTypeByID(String lookupTypeId)
	{
		LOGGER.debug(
				"LookupDatabaseServiceImpl - getTypeByID() - Searching lookup type repository with id of "
						+ lookupTypeId);

		return lookupTypeRepository.findById(lookupTypeId);
	}

	@Override
	public Optional<LookupReference> getReferenceByNameAndParentType(String lookupTypeName,
			String lookupReferenceName) 
	{
		LOGGER.debug(
				"LookupDatabaseServiceImpl - getReferenceByName() - Searching lookup reference repository with parent lookup type name of "
						+ lookupTypeName + " and lookup reference name of " + lookupReferenceName);

		return lookupReferenceRepository.findOne(
				LookupReferenceExpressions
				.hasLookupReferenceName(lookupReferenceName)
				.and(LookupReferenceExpressions.hasLookupTypeName(lookupTypeName)));
	}
	
	@Override
	public List<LookupReference> getAllReferencesByLookupTypeName(
			String lookupTypeName)
	{
		LOGGER.debug(
				"LookupDatabaseServiceImpl - getAllReferencesByLookupType() - Searching lookup reference repository that have parent lookup name of "
						+ lookupTypeName);

		List<LookupReference> lookupReferences = (List<LookupReference>) lookupReferenceRepository.findAll(LookupReferenceExpressions.hasLookupTypeName(lookupTypeName));

		LOGGER.debug(
				"LookupDatabaseServiceImpl - getAllReferencesByLookupType() - Found "
						+ lookupReferences.size()
						+ " lookup references that have parent lookup type name of "
						+ lookupTypeName);

		return lookupReferences;
	}
}
