package com.bottlerocket.coding.challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bottlerocket.coding.challenge.domain.LookupReference;


public interface LookupReferenceRepository extends JpaRepository<LookupReference, String>, QuerydslPredicateExecutor<LookupReference>
{

}
