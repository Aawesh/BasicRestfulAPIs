package com.aawesh.springbootstarter.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//This handles all the crud operation. We do not need to implement all 
//Just create an interface and extend it with CrudRepositor<EntityClass,Id data type>
public interface CourseRepository extends CrudRepository<Course,String> {
	
	/*
	 * if you want to find course by id then naming convention of the method name is
	findByMethodName start with findBy always and followed by the property name
	You don't need to do anything, just declare the method name with the naming convention and 
	the framework will handle the stuffs
	*/
	//public List<Course>findByName(String name);
	//public List<Course>findById(String id);
	
	//Now in this case we are trying to find the list of courses for a particular id
	//So, we might write a method name called findByTopic but this is not going to work
	//because the Topic again has some set of properties that we want to mettion
	//In this case, we will mention the topic Id so the method name will be findByTopicId
	//Remember all the name must be in camel-case
	public List<Course> findByTopicId(String topicId);
	
}
