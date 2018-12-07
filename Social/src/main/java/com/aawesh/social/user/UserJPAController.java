package com.aawesh.social.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserJPAController {
		
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/jpa/users")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	

// 	Things to be noted: Always user ControllerLinkBuilder in a controller class, otherwise it won't work, returns null uri
	@GetMapping("/jpa/users/{id}")
	public Resource<User> getUser(@PathVariable Integer id){
		User user = userService.getUser(id);
		
		//link to all users
		//using hateoas
		Resource<User> resource = new Resource<User>(user);
		
		ControllerLinkBuilder linkBuilder = linkTo(methodOn(this.getClass()).getAllUsers());
		resource.add(linkBuilder.withRel("all-users"));
		
		return resource;
	}
	
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user){
		return userService.addUser(user);
	}
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUserById(@PathVariable Integer id) {
		userService.deleteUser(id);
	}
	
	@PutMapping("/jpa/users/{id}")
	public void updateUser(@PathVariable Integer id, @Valid @RequestBody User user) {
		userService.updateUser(id,user);
	}
	
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> getAllPosts(@PathVariable Integer id){
		return userService.getAllPosts(id);
	}
	
	@GetMapping("/jpa/users/{userId}/posts/{postId}")
	public Resource<Post> getPost(@PathVariable Integer userId, @PathVariable Integer postId){
		Post post = userService.getPost(userId,postId);
		
		//link to all Posts
		//using hateoas
		Resource<Post> resource = new Resource<Post>(post);
		
		ControllerLinkBuilder linkBuilder = linkTo(methodOn(this.getClass()).getAllPosts(userId));
		resource.add(linkBuilder.withRel("all-posts"));
		
		return resource;
	}
	
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> savePost(@PathVariable Integer id, @RequestBody Post post){
		User user = userService.getUser(id);
		return userService.addPost(user,post);
		
	}
	

	@DeleteMapping("/jpa/users/{userId}/posts/{postId}")
	public void deletePostById(@PathVariable Integer userId, @PathVariable Integer postId) {
		userService.deletePost(userId,postId);
	}
	
	@PutMapping("/jpa/users/{userId}/posts/{postId}")
	public void updatePost(@PathVariable Integer userId, @PathVariable Integer postId,@RequestBody Post post) {
		userService.updatePost(userId,postId,post);
	}
	
}

