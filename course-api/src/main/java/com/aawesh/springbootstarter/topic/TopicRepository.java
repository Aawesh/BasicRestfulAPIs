package com.aawesh.springbootstarter.topic;

import org.springframework.data.repository.CrudRepository;

//This handles all the crud operation. We do not need to implement all 
//Just create an interface and extend it with CrudRepositor<EntityClass,Id data type>
public interface TopicRepository extends CrudRepository<Topic,String> {
}
