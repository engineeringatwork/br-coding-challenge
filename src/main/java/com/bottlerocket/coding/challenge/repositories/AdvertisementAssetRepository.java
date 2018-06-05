package com.bottlerocket.coding.challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bottlerocket.coding.challenge.domain.AdvertisementAsset;


public interface AdvertisementAssetRepository extends JpaRepository<AdvertisementAsset, String>, QuerydslPredicateExecutor<AdvertisementAsset>
{

}
