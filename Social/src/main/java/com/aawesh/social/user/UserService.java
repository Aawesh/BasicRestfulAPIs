package com.aawesh.social.user;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.security.cert.PKIXRevocationChecker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User getUser(Integer id) {
		Optional<User> user =  userRepository.findById(id);
		if(!user.isPresent()) {			
			throw new UserNotFoundException("id - "+id);
		}else {
			return user.get();
		}
	}
 	
	
	public ResponseEntity<Object> addUser(User user) {
		
		User savedUser = userRepository.save(user);
		URI location = ServletUriComponentsBuilder.
				fromCurrentRequest().
				path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
	public void updateUser(Integer id, User user) {
		Optional<User> userOptional = userRepository.findById(id);
		
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("id-"+id);
		}
		userRepository.save(user);
	}
	
	public void deleteUser(Integer id) {
		Optional<User> userOptional = userRepository.findById(id);
		
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("id-"+id);
		}
		
		userRepository.deleteById(id);
	}
	
	public List<Post> getAllPosts(Integer id){
		Optional<User> userOptional = userRepository.findById(id);
		
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("id-"+id);
		}
		
		return userOptional.get().getPosts();
	}
	
	public Post getPost(Integer userId, Integer postId){
		Optional<User> userOptional = userRepository.findById(userId);
		
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("id-"+userId);
		}
		
		Optional<Post> postOptional = postRepository.findById(postId);
		if(!postOptional.isPresent()) {
			throw new PostNotFoundException("postId-"+postId);
		}
		
		return postOptional.get();
	}
	
	
	public ResponseEntity<Object> addPost(User user, Post post) {
		
		post.setUser(user);
		postRepository.save(post);
		
		URI location = ServletUriComponentsBuilder.
				fromCurrentRequest().
				path("/{id}")
				.buildAndExpand(post.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
	public void deletePost(Integer userId, Integer postId) {
		Optional<User> userOptional = userRepository.findById(userId);
		
		
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("user-id - "+userId);
		}
		
		Optional<Post> postOptional = postRepository.findById(postId);
		
		if(!postOptional.isPresent()) {
			throw new PostNotFoundException("post-id-"+postId);
		}
		
		postRepository.deleteById(postId);
	}
	
	public void updatePost(Integer userId, Integer postId, Post post) {
		Optional<User> userOptional = userRepository.findById(userId);
		
		
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("user-id - "+userId);
		}
		
		Optional<Post> postOptional = postRepository.findById(postId);
		
		if(!postOptional.isPresent()) {
			throw new PostNotFoundException("post-id-"+postId);
		}
		
		postRepository.save(post);
	}

}
