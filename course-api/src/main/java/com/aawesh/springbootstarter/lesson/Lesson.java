package com.aawesh.springbootstarter.lesson;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.aawesh.springbootstarter.course.Course;
import com.aawesh.springbootstarter.topic.Topic;

@Entity
public class Lesson {

	@Id
	public String id;
	public String name ;
	public String description;
	
	@ManyToOne
	public Course course;
	

	public Lesson() {
	}
	
	public Lesson(String id, String name, String description,String courseId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.course = new Course(courseId,"","","");
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
}
