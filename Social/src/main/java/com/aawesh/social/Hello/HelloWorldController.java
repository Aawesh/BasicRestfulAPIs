package com.aawesh.social.Hello;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {


	@Autowired
	private MessageSource messageSource;
	
	@GetMapping("/hello")
	public HelloWorld hello() {
		return new HelloWorld("Good Morning");
	}
	
/*	@GetMapping("/hello-international")
	public String hello(@RequestHeader(name="Accept-Language",required=false) Locale locale) {
		return messageSource.getMessage("good.morning.message",null,locale);
	}*/
	

	@GetMapping("/hello-international")
	public String helloInternational() {
		return messageSource.getMessage("good.morning.message",null,LocaleContextHolder.getLocale());
	}
}
