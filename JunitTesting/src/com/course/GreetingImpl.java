package com.course;

public class GreetingImpl implements Greeting {

	@Override
	public String greetings(String name) {

		if (name == null || name.length() == 0) {
			throw new IllegalArgumentException();
		}

		return "Hello " + name;
	}

	@Override
	public void bye(String name) {
		System.out.println("Bye " + name);
	}

	public static void main(String[] args) {

		Greeting greet = new GreetingImpl();
		String message = greet.greetings("Guna");

		System.out.println(message);

		greet.bye("guna");
	}
}
