package com.csquare.ref.dao;

import org.springframework.stereotype.Repository;

import com.csquare.framework.entity.BaseJpaRepository;
import com.csquare.ref.model.RefLocation;

@Repository
public class RefLocationRepository extends BaseJpaRepository<RefLocation, String> {

}
