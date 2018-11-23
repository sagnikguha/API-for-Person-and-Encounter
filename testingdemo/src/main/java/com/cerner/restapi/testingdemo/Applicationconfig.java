package com.cerner.restapi.testingdemo;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class Applicationconfig extends Application{
	
	 @Override
	    public Map<String, Object> getProperties() {
	        Map<String, Object> properties = new HashMap<String, Object>();
	        properties.put("jersey.config.server.provider.packages", "com.cerner.restapi.testingdemo");
	        return properties;
	    }

}
