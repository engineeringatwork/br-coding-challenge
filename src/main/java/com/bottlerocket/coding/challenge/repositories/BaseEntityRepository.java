/*
 * Copyright 2017 Lockheed Martin Corporation, All rights reserved.
 */

package com.bottlerocket.coding.challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bottlerocket.coding.challenge.domain.BaseEntity;

public interface BaseEntityRepository extends JpaRepository<BaseEntity, String>
{

}
