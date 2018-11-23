package com.cerner.restapi.testingdemo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/encounter")
public class ApplicationService {

	EncounterDTO encounterDto = new EncounterDTO();
	Encounter encounter = new Encounter();

	@GET
	@Path("{id: .*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Encounter getAllEncounterId(@PathParam("id") String id) {
		try {
			if (id == null || id.isEmpty() || !id.matches("\\d+")) {
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			System.out.println(e);
			encounter.setStatus("FALSE");
			return encounter;
		}

		Long Id = Long.parseLong(id);
		if (Id <= 0) {
			encounter.setStatus("FALSE");
			return encounter;
		} else {
			if (encounterDto.getEncounterById(Id).getStatus() == null) {
				encounter.setStatus("FALSE");
				return encounter;
			} else {
				return encounterDto.getEncounterById(Id);
			}
		}
	}

//	@GET
//	@Path("{id: .*}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response<Encounter> fetchBy(@PathParam("id") String id) {
//		
//		Response<Encounter> response = new Response<Encounter>();
//		if(id == null || id.isEmpty()) {
//			response.setStatus(false);
//			response.setCode(404);
//			return response;
//		}else {
//			Long Id = Long.parseLong(id);
//			if(Id <= 0) {
//				response.setStatus(false);
//				response.setCode(404);
//				return response;
//			}
//			else {
//				response.setStatus(true);
//				response.setCode(200);
//				response.setResult(encounterDto.getEncounterById(Id));
//				return response;
//			}
//		}
//	}

}
