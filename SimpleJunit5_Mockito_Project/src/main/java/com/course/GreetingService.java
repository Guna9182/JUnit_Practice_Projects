package com.course;

public class GreetingService {

	
	private DaoRepo repo;

	public GreetingService(DaoRepo repo) {
		this.repo = repo;
	}

	public String greeting(String name) {
		
		boolean validated = validateName(name);
		
		if(validated)
			return repo.getGreeting() + ", " + name;
		throw new IllegalArgumentException();
	}

	public boolean getNameById(int id) {

		try {
			String name = repo.getById(id);

			if (name == null) {
				throw new IllegalArgumentException();
			}

		} catch (Exception e) {
			throw new IllegalArgumentException("No Name found");
		}

		return true;
	}
	
	public void DeleteByIdInService(int id) {
		repo.deleteById(id);
	}
	
	private boolean validateName(String name) {
		return name != null && !name.isEmpty();
	}
}
