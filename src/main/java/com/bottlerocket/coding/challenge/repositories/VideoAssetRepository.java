package com.bottlerocket.coding.challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bottlerocket.coding.challenge.domain.VideoAsset;


public interface VideoAssetRepository extends JpaRepository<VideoAsset, String>, QuerydslPredicateExecutor<VideoAsset>
{

}
