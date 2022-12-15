package com.in28minutes.springboot.firstApiRest.helloworld;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldResource {
	
	@RequestMapping(value = "/hello-world")
	public String helloWorld() {
		return "Hello";
	}
	
	@RequestMapping(value = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	
	@RequestMapping(value = "/hello-world-path-param/{name}")
	public HelloWorldBean helloWorldPathParam(@PathVariable String name) {
		return new HelloWorldBean("Hello World, " + name);
	}
	
	@RequestMapping(value = "/hello-world-path-param/{name}/message/{message}")
	public HelloWorldBean helloWorldMultiplePathParam(@PathVariable String name, @PathVariable String message) {
		return new HelloWorldBean("Hello World, " + name + ", " + message);
	}
	
	
}
