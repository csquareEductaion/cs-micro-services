package com.csquare.ums.service;

import com.csquare.ums.entity.Tutor;

public interface ITutorService {
	
	
	public Tutor addUpdateTutor(Tutor tutor);
	public Tutor getTutorById(Long tutorid);

}
