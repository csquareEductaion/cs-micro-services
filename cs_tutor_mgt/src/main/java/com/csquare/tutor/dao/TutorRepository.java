package com.csquare.tutor.dao;

import org.springframework.stereotype.Repository;

import com.csquare.framework.entity.BaseJpaRepository;
import com.csquare.tutor.model.Tutor;


@Repository
public class TutorRepository extends BaseJpaRepository<Tutor, String> {

}

