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

import com.cerner.restapi.testingdemo.PersonService;

public class PersonTest extends JerseyTest {
	@Override
	public Application configure() {
/**
 *  For a purpose of running multiple test containers in parallel
 *  you need to set the TestProperties.CONTAINER_PORT to 0 value.
 *	This will tell Jersey Test Framework (and the underlying test container) to use the first available port.
 */
		forceSet(TestProperties.CONTAINER_PORT, "0");
		return new ResourceConfig(PersonService.class);
	}

	@Test
	public void getAllPersonIdTestMethodNotAllowed() {
		Response output = target("/person/").request().get();
		Assert.assertEquals("Should not return status 200", 200, output.getStatus());
	}

	@Test
	public void getAllPersonIdTest() {
		Response output = target("/person/1").request().get();
		assertEquals("Should return status 200", 200, output.getStatus());
		assertNotNull("Should return Person", output.getEntity());
	}

	@Test
	public void getAllPersonIdTestWithZero() {
		Response output = target("/person/0").request().get();
		Assert.assertNotEquals("Should return not status 404", 404, output.getStatus());
		assertNotNull("Should return Person", output.getEntity());
	}
	
	@Test
	public void getAllPersonIdTestNegativeNumber() {
		Response output = target("/person/-1").request().get();
		Assert.assertNotEquals("Should return not status 404", 404, output.getStatus());
		assertNotNull("Should return Person", output.getEntity());
	}
}
