package com.aawesh.social.user;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description="Details about the user goes here")
public class User {
	
	@Id
	//@GeneratedValue
	private Integer id;
	
	@Size(min = 2,message = "Name should be at least two characters")
	@ApiModelProperty(notes = "Name should be at least two characters")
	private String name;
	
	@Past
	@ApiModelProperty(notes="DOB should be before current time")
	//@JsonIgnore 
	// Use the above annotation to exclude a field from the response
	//This is a static filtering
	private Date dob;
	
	
	//One user can have many posts so One to many because we are in User class and creating List<Post> variable so, it is one to many
	@OneToMany(mappedBy="user") // "user" is the name of the field in Post class that is User user;
	private List<Post> posts;
	
	public User() {
		super();
	}
	
	public User(Integer id, String name, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.dob = date;
	}
	
	public Integer getId () {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getDob() {
		return dob;
	}
	
	public void setDob(Date dob) {
		this.dob = dob;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dob=" + dob + "]";
	}
	
	
}
