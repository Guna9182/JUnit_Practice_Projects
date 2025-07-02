package com.course;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GreetingImplTest {
	
	private Greeting greet;
	
	@Before //this setUp is done before each method going to run
	public void setUp() {
		System.out.println("Set Up done");
		greet = new GreetingImpl();
	}

	@Test
	public void testingGreeting() {
		
		String actualMessage = greet.greetings("Junit");
		
		assertEquals("Output is not as expected..!", "Hello Junit", actualMessage);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void greetingShouldReturnAnExceptionForNameIsNull() {
		
		greet.greetings(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void greetingShouldReturnAnException_For_NameIsBlank() {
		
		greet.greetings("");
	}

	@After
	public void tearDown() {
		System.out.println("Tear down done");
		greet = null;
	}
}
