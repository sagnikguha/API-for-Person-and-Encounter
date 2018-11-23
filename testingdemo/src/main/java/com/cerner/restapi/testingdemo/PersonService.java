package com.cerner.restapi.testingdemo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/person")
public class PersonService {

	Person person = new Person();
	PersonDTO personDto = new PersonDTO();
	

//	@GET
//	@Path("{id: .*}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response<Person> getAllPersonById(@PathParam("id") String id) {
//		System.out.println("Inside the api, the id is " + id);
//		Response<Person> response = new Response<Person>();
//		int Id;
//		try {
//			Id = Integer.parseInt(id);
//		} catch (NumberFormatException e) {
//			response.setStatus(false);
//			response.setCode(404);
//			return response;
//		}
//		if(Id <= 0) {
//			response.setStatus(false);
//			response.setCode(404);
//			return response;
//		}
//		else {
//			response.setStatus(true);
//			response.setCode(200);
//			response.setResult(personDto.getAllPerson(Id));
//			return response;
//		}	
//	}

	@GET
	@Path("{id: .*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Person getAllPersonId(@PathParam("id") String id) {
		System.out.println(id);
		try { 
			if (id == null || id.isEmpty() || !id.matches("\\d+")) {
				throw new Exception("The argument cannot be null");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			person.setStatus("FALSE");
			return person;
		}
		int Id = Integer.parseInt(id);
		if(Id <= 0) {
			person.setStatus("FALSE");
			return person;
		}
		else {
			if(personDto.getAllPerson(Id).getStatus()==null) {
				person.setStatus("FALSE");
				return person;
			}
			else {
				return personDto.getAllPerson(Id);
			}
		}
	}
}
