package com.aawesh.social.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.query.criteria.internal.expression.function.AggregationFunction.COUNT;
import org.springframework.stereotype.Component;

import net.bytebuddy.asm.Advice.Return;

@Component
public class UserDaoService {
	
	private static List<User> userList = new ArrayList<>();
	
	private static int count = 3;
	
	static {
		userList.add(new User(1, "Jack", new Date()));
		userList.add(new User(2, "Robin", new Date()));
		userList.add(new User(3, "Rob", new Date()));
	}
	
	public List<User> findAll(){
		return userList;
	}	
	
	public User findOne(int id) {
		for(User user: userList) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	public User save(User user) {
		if(user.getId() == null) {
			user.setId(++count);
		}
		userList.add(user);
		return user;
	}
	
	public User deleteById(Integer id) {
		Iterator<User> iterator = userList.iterator();
		while(iterator.hasNext()) {
			User user = iterator.next();
			if(user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}
}
