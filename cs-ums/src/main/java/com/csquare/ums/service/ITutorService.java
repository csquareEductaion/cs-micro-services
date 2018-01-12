package com.csquare.ums.service;

import com.csquare.ums.model.Tutor;


public interface ITutorService {

    public Tutor addUpdateTutor(Tutor tutor);

    public Tutor getTutorById(Long tutorid);

}
