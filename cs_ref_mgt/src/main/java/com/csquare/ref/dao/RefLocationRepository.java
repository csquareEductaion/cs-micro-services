package com.csquare.ref.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.csquare.framework.entity.BaseJpaRepository;
import com.csquare.ref.model.RefLocation;


@Repository
public class RefLocationRepository extends BaseJpaRepository<RefLocation, String> {

	public List<RefLocation> searchLocationByCity(String city) {
		// TODO Auto-generated method stub
		return findAll(city);
	}

}
