package com.aawesh.social.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersionCotroller {
	
	//One way to do is to have a separate controller for several uri without any params
	
	@GetMapping("/person/v1")
	public PersonV1 getNameV1() {
		return new PersonV1("Aawesh Shrestha");
	}
	
	@GetMapping("/person/v2")
	public PersonV2 getNameV2() {
		return new PersonV2("Aawesh", "Shrestha");
	}
	
	//Another way to do it is by sending params value in the browser
	
	//parameter versioning
	//Normal user can send request from a browser
	
	@GetMapping(value = "/person/param",params="value=1")
	public PersonV1 PersonParamV1() {
		return new PersonV1("Aawesh Shrestha");
	}
	
	@GetMapping(value = "/person/param",params="value=2")
	public PersonV2 PersonParamV2() {
		return new PersonV2("Aawesh" ,"Shrestha");
	}
	
	
	//User Headers to send
	//X-API-VERSION			1
	
	//But headers were never meant to versioning. Two different uri looks same but provides different result because of header
	//General user may not perform this kind of request, need some extra plugins like postman
	@GetMapping(value = "/person/header",headers="X-API-VERSION=1")
	public PersonV1 PersonHeaderV1() {
		return new PersonV1("Aawesh Shrestha");
	}
	
	@GetMapping(value = "/person/header",headers="X-API-VERSION=2")
	public PersonV2 PersonHeaderV2() {
		return new PersonV2("Aawesh" ,"Shrestha");
	}
	
	//using 'produces'
	//content negotiation or Accept versioning
	
	//In this kind of versioning, the url is populated, but it supports caching and any kind of user my perform this kind of request
	//Normal user can send request from a browser
	@GetMapping(value = "/person/produces",produces="application/com.aawesh.social-v1+json")
	public PersonV1 PersonProducesV1() {
		return new PersonV1("Aawesh Shrestha");
	}
	
	@GetMapping(value = "/person/produces",produces="application/com.aawesh.social-v2+json")
	public PersonV2 PersonProducesV2() {
		return new PersonV2("Aawesh" ,"Shrestha");
	}
	
	
	
	
	
}
