package com.cerner.testcase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import com.cerner.restapi.testingdemo.Person;

public class PersonPojoTest {
	Person personInstance = null ; 
	@Before
	public void setUp() {
		personInstance = new Person();
	}
	
	@Test
	public void activeIndTest() {
		personInstance.setActiveInd(1);
		assertEquals(new Integer(1), personInstance.getActiveInd());
	}
	@Test
	public void activeIndTestNegativeNumber() {
		personInstance.setActiveInd(-1);
		assertNotEquals(new Integer(1), personInstance.getActiveInd());
	}
	
	@Test
	public void nameFirstTest() {
		personInstance.setNameFirst("Sagnik");
		assertEquals("Sagnik", personInstance.getNameFirst());
	}
	
	@Test
	public void nameFirstTestWrongInput() {
		personInstance.setNameFirst("Sagnik");
		assertNotEquals("Avik", personInstance.getNameFirst());
	}
	
	@Test
	public void nameLastTest() {
		personInstance.setNameLast("Guha");
		assertEquals("Guha", personInstance.getNameLast());
	}
	
	@Test
	public void nameLastTestWrongInput() {
		personInstance.setNameLast("Guha");
		assertNotEquals("Ghosh", personInstance.getNameLast());
	}
	
	@Test
	public void personIdTest() {
		personInstance.setPersonId(1);
		assertEquals(new Integer(1), personInstance.getPersonId());
	}
	
	@Test
	public void personIdTestNegativeNumber() {
		personInstance.setPersonId(1);
		assertNotEquals(new Integer(4), personInstance.getPersonId());
	}
}
