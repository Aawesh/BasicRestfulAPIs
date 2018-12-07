package com.aawesh.springbootstarter.lesson;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//This handles all the crud operation. We do not need to implement all 
//Just create an interface and extend it with CrudRepositor<EntityClass,Id data type>
public interface LessonRepository extends CrudRepository<Lesson,String> {
	
	public List<Lesson> findByCourseId(String courseId);
}
