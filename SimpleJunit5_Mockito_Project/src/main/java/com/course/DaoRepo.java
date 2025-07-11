package com.course;

public interface DaoRepo {

//	default String getGreeting() {
//		return "Hello";
//	}
	
	String getGreeting();
	
	void saySomeThing();

	String getById(int id);
	
	void deleteById(int id);
}
