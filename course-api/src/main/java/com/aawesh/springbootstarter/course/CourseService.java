package com.aawesh.springbootstarter.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//This is a Business service class, a singleton class which spring handles
@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	//TODO
	public List<Course>getAllCourses(String topicId){
		List<Course> courseList = new ArrayList<>();
		courseRepository.findByTopicId(topicId).forEach(courseList::add);
		return courseList;
	}
	
	public Course getCourse(String id){
		return courseRepository.findOne(id);
	}
	
	public void addCourse(Course course) {
		courseRepository.save(course);
	}
	

	public void updateCourse(Course course) {
		courseRepository.save(course);
	}
	
	public void deleteCourse(String id) {
		courseRepository.delete(id);
	}
}
