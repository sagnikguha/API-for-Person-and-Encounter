package com.cerner.testcase;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Assert;
import org.junit.Test;

import com.cerner.restapi.testingdemo.ApplicationService;

public class EncounterTest extends JerseyTest {

	@Override
	public Application configure() {
		forceSet(TestProperties.CONTAINER_PORT, "0");
		return new ResourceConfig(ApplicationService.class);
	}

	@Test
	public void getAllEncounterIdTestMethodNotAllowed() {
		Response output = target("/encounter/").request().get();
		Assert.assertEquals("Should not return status 200", 200, output.getStatus());
	}

	@Test
	public void getAllEncounterIdTest() {
		Response output = target("/encounter/1").request().get();
		assertEquals("Should return status 200", 200, output.getStatus());
		assertNotNull("Should return EncounterInformation", output.getEntity());
	}

	@Test
	public void getAllEncounterIdTestWithZero() {
		Response output = target("/encounter/0").request().get();
		Assert.assertNotEquals("Should return status 404", 404, output.getStatus());
		assertNotNull("Should return Person", output.getEntity());
	}

	@Test
	public void getAllEncounterIdTestNegativeNumber() {
		Response output = target("/encounter/-1").request().get();
		Assert.assertNotEquals("Should not return status 404", 404, output.getStatus());
	}
}
