package com.cerner.testcase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.cerner.restapi.testingdemo.Encounter;

public class EncounterPojoTest {
	Encounter encounterInstance = null ;
	@Before
	public void setUp() {
		encounterInstance = new Encounter();
	}
	@Test
	public void activeIndTest() {
		encounterInstance.setActiveInd(0);
		assertEquals(0, encounterInstance.getActiveInd());
	}
	@Test
	public void activeIndTestWrongInput() {
		encounterInstance.setActiveInd(1);
		assertNotEquals(0, encounterInstance.getActiveInd());
	}
	@Test
	public void encntrIdTest() {
		encounterInstance.setEncntrId(40982);
		assertEquals(40982, encounterInstance.getEncntrId());
	}
	@Test
	public void encntrIdTestWrongInput() {
		encounterInstance.setEncntrId(5003);
		assertNotEquals(5004, encounterInstance.getEncntrId());
	}
	@Test
	public void encntrTypeCdTest() {
		encounterInstance.setEncntrTypeCd(40001);
		assertEquals(40001, encounterInstance.getEncntrTypeCd());
	}
	@Test
	public void encntrTypeCdTestWrongInput() {
		encounterInstance.setEncntrTypeCd(40001);
		assertNotEquals(400234, encounterInstance.getEncntrTypeCd());
	}
	@SuppressWarnings("deprecation")
	@Test
	public void registrationDateTest() {
		Date date = new Date("02/01/1993");
		encounterInstance.setRegistrationDate(date);
		assertEquals(date, encounterInstance.getRegistrationDate());
	}
	@Test
	public void dischargeDateTest() {
		@SuppressWarnings("deprecation")
		Date date = new Date("02/01/1993");
		encounterInstance.setDischargeDate(date);
		assertEquals(date, encounterInstance.getDischargeDate());
	}
}
