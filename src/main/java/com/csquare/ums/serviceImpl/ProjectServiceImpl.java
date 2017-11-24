package com.csquare.ums.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.csquare.ums.dao.ProjectDao;
import com.csquare.ums.entity.Student;
import com.csquare.ums.service.ProjectService;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDao projectDao;
	@Override
	public Student sayHello() {
		// TODO Auto-generated method stub
		return projectDao.findById(1);
	}

}
