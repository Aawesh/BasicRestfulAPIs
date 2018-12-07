package com.aawesh.springbootstarter.lesson;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aawesh.springbootstarter.course.Course;
import com.aawesh.springbootstarter.topic.Topic;

@RestController
public class LessonController {
	
	@Autowired
	private LessonService lessonService;

	//This returns the list of topic and spring converts it into json and returns it as a response
	@RequestMapping("/topics/{topicId}/courses/{courseId}/lessons")
	public List<Lesson> getAllLessons(@PathVariable String courseId){
		return lessonService.getAllLessons(courseId);
	}
	
	//{id} means id can be anything.. making it more general
	// @PathVariable assigns topics/id to String id parameter in the getTopic Method 
	@RequestMapping("/topics/{topicId}/courses/{courseId}/lessons/{lessonId}")
	public Lesson getLesson(@PathVariable String lessonId) {
		return lessonService.getLesson(lessonId);
	}
	
	//make a post request
	@RequestMapping(method=RequestMethod.POST,value="/topics/{topicId}/courses/{courseId}/lessons")
	public void addLesson(@RequestBody Lesson lesson, @PathVariable String topicId, @PathVariable String courseId) {
		lesson.setCourse(new Course(courseId,"","",topicId));
		lessonService.addLesson(lesson);
	}
	
	//make a put request
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{topicId}/courses/{courseId}/lessons/{lessonId}")
	public void updateLesson(@RequestBody Lesson lesson,@PathVariable String topicId, @PathVariable String courseId) {
		lesson.setCourse(new Course(courseId,"","",topicId));
		lessonService.updateLesson(lesson);
	}
	
	//make a delete request
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{id}/courses/{courseId}/lessons/{lessonId}")
	public void deleteLesson(@PathVariable String lessonId) {
		lessonService.deleteLesson(lessonId);
	}
	
	
	
}
