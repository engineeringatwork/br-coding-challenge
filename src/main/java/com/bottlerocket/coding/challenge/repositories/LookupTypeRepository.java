/*
 * Copyright 2017 Lockheed Martin Corporation, All rights reserved.
 */

package com.bottlerocket.coding.challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bottlerocket.coding.challenge.domain.LookupType;


public interface LookupTypeRepository extends JpaRepository<LookupType, String>, QuerydslPredicateExecutor<LookupType>
{

}
