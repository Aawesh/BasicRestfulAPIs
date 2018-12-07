package com.aawesh.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//This is a Business service class, a singleton class which spring handles
@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("Spring","Spring", "Spring desciption"),
			new Topic("Java","Core Java", "Core Java desciption"),
			new Topic("Anno","Annotation", "Annotation desciption")
			));	
	
	
	public List<Topic>getAllTopics(){
		//Previously it was returned the topics that was hardcoded above
		List<Topic> topicList = new ArrayList<>();
		topicRepository.findAll().forEach(topicList::add);
		return topicList;
	}
	
	public Topic getTopic(String id){
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return topicRepository.findOne(id);
	}
	
	public void addTopic(Topic topic) {
//		topics.add(topic);
		topicRepository.save(topic);
	}
	

	public void updateTopic(String id,Topic topic) {
		/*for(int i = 0;i<topics.size();i++) {
			if(topics.get(i).id.equalsIgnoreCase(id)) {
				topics.set(i, topic);
				return;
			}
		}*/
		
		//updates topic if it exists
		topicRepository.save(topic);
	}
	
	public void deleteTopic(String id) {
		/*for(int i = 0;i<topics.size();i++) {
			if(topics.get(i).id.equalsIgnoreCase(id)) {
				topics.remove(i);
				return;
			}
		}*/
		topicRepository.delete(id);
	}
}
