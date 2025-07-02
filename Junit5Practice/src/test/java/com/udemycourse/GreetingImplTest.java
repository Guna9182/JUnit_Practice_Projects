package com.udemycourse;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GreetingImplTest {

	private Greeting greet;

//	@Before //this setUp is done before each method going to run -- in Junit4
	@BeforeEach // in JUnit 5
	public void setUp() {
		System.out.println("Set Up done");
		greet = new GreetingImpl();
	}

	@Test
	public void testingGreeting() {

		String actualMessage = greet.greetings("Junit");

		Assertions.assertEquals("Hello Junit", actualMessage);
	}

	@Test
	public void greetingShouldReturnAnExceptionForNameIsNull() {

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			greet.greetings(null);
		});
	}

	@Test
	public void greetingShouldReturnAnException_For_NameIsBlank() {

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			greet.greetings("");
		});
	}

	@AfterEach
	public void tearDown() {
		System.out.println("Tear down done");
		greet = null;
	}
}
