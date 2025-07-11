package com.course;

public class AppMain {

	public static void main(String[] args) {
		
		DaoRepo repo = new DaoRepo() {
			
			@Override
			public void saySomeThing() {
			}
			
			@Override
			public String getGreeting() {
				return "Hello -";
			}

			@Override
			public String getById(int id) {
				return "Raki";
			}

			@Override
			public void deleteById(int id) {
				// TODO Auto-generated method stub
				
			}
		};
		
		GreetingService greet = new GreetingService(repo);
		
		System.out.println(greet.greeting("Guna"));
		
		System.out.println(greet.greeting(null));
		
		System.out.println(greet.getNameById(2));
	}
}
