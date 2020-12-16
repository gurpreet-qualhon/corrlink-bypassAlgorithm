package com.example.bypassAlgorithm.controller;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bypassAlgorithm.duo.CourseDao;
import com.example.bypassAlgorithm.entity.Courses;

@Service
public class CourseServiceImp implements CourseService{
	
//	List<Courses> list;
	@Autowired
	private CourseDao courseDao;
	
	public CourseServiceImp() {
		// TODO Auto-generated constructor stub	
//		list = new ArrayList<Courses>();
//		list.add(new Courses("Java","This is my Fav"));
//		list.add(new Courses("Mysql","This is my Fav"));
		
	
	}
	
	@Override
	public List<Courses> getCourses() {
		// TODO Auto-generated method stub
		
		return courseDao.findAll();
	}
	
	

}
