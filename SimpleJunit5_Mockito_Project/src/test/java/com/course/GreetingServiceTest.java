package com.course;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.booleanThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GreetingServiceTest {

	@Mock
	private DaoRepo repo;

	@InjectMocks
	private GreetingService service;
	
	@BeforeAll
	public static void init() {
		System.out.println("Before All Init..");
	}

	// No need to use this (MockitoAnnotations.openMocks(this);),
//	   if @ExtendWith is using in JUnit-5
	@BeforeEach
	void setUp() {
//		MockitoAnnotations.openMocks(this);
		System.out.println("Before each method");
	}
	
	@AfterEach
	void setUpAfterEach() {
		System.out.println("After each method");
	}

	@Test
	void greetingShouldReturnValidly() {
		//stubbing means setting mock values, this is doing because of Mockito
		when(repo.getGreeting()).thenReturn("Hello");
		
		String result = service.greeting("Guna");
		System.out.println(result);
		
		//Both from Assertions class of JUnit-5
		Assertions.assertNotNull(result);
		assertEquals("Hello, Guna", result);
		
		//for verifying whether method is called or not.
		verify(repo).getGreeting();
	}
	
	@Test
	void greetingShouldThrow_Exception() {
		when(repo.getGreeting()).thenThrow(IllegalArgumentException.class);
		
		assertThrows(IllegalArgumentException.class,()->{
			service.greeting("REMO");
		});
	}

	@Test
	void GetByIdShouldReturn_True() {
		when(repo.getById(1)).thenReturn("Raki");
		
		boolean result = service.getNameById(1);
		assertTrue(result);
	}

	@Test
	void handlingException_OfGetByID() {
		when(repo.getById(1)).thenThrow(IllegalArgumentException.class);
//		this assertThrows() is used to check when exception is throwing.
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			service.getNameById(1);
		});
	}
	
	@Test
	void testDeleteById() {
		doNothing().when(repo).deleteById(1);
		
		service.DeleteByIdInService(1);
		verify(repo, times(1)).deleteById(1);
	}

	//this test case is to test private method  
	@Test
	void testPrivateMethod_ShouldReturnTrue() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Method validateNameMethod = GreetingService.class
				.getDeclaredMethod("validateName", String.class);
		
		validateNameMethod.setAccessible(true);
		
		boolean result = (boolean) validateNameMethod.invoke(service, "Guna");
		
		assertTrue(result);
	}
}
