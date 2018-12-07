package com.aawesh.springbootstarter.lesson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//This is a Business service class, a singleton class which spring handles
@Service
public class LessonService {
	
	@Autowired
	private LessonRepository lessonRepository;
	
	//TODO
	public List<Lesson>getAllLessons(String courseId){
		List<Lesson> lessonList = new ArrayList<>();
		lessonRepository.findByCourseId(courseId).forEach(lessonList::add);
		return lessonList;
	}
	
	public Lesson getLesson(String id){
		return lessonRepository.findOne(id);
	}
	
	public void addLesson(Lesson lesson) {
		lessonRepository.save(lesson);
	}
	

	public void updateLesson(Lesson lesson) {
		lessonRepository.save(lesson);
	}
	
	public void deleteLesson(String id) {
		lessonRepository.delete(id);
	}
}
