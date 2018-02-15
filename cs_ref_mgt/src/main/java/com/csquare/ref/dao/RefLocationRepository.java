package com.csquare.ref.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csquare.framework.entity.BaseJpaRepository;
import com.csquare.ref.model.RefLocation;

@Repository
public interface RefLocationRepository extends JpaRepository<RefLocation, String> {
	
	public List<RefLocation> findAllByCity(String city);
}
