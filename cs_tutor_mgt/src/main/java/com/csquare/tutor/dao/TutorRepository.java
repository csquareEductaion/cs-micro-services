package com.csquare.tutor.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.csquare.framework.entity.BaseJpaRepository;
import com.csquare.tutor.model.Tutor;


@Repository
public interface TutorRepository extends JpaRepository<Tutor, String> {

	@Query(value = "select DISTINCT tutor.tutor_id,tutor.gender, tutor.grade, tutor.aadhar_verified, tutor.address, tutor.first_name,tutor.last_name, tutor.comment,tutor.have_vechile, tutor.experience_in_years, tutor.alternate_phone, tutor.verify_without_aadhar, tutor.subm_higher_edu_doc, tutor.is_phone_dnd, tutor.is_interested_for_home_tuition, tutor.qualification, tutor.follo_up_required, tutor.interview_date, tutor.interview_time, tutor.category, tutor.round_cleared, tutor.preffered_timing, tutor.preffered_days, tutor.email, tutor.phone, tutor.city, tutor.location, tutor.verified, tutor.is_trusted_tutor from tutor_mgt.tutor INNER JOIN tutor_mgt.tutor_grade ON  (tutor.tutor_id = tutor_grade.tutor_id) where email = :email OR phone = :phone OR city = :city OR gender = :gender OR location = :location OR is_trusted_tutor=:is_trusted_tutor OR verified=:verified OR grade_id =:grade ; ", nativeQuery = true)
	public List<Tutor> findByParams(@Param("email")String email, @Param("phone")String phone, @Param("city")String city, @Param("location")String location, @Param("gender")String gender, @Param("grade")String grade, @Param("verified")Boolean verified, @Param("is_trusted_tutor")Boolean is_trusted_tutor);
	
}

