package com.cerner.restapi.testingdemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonDTO {
	
	public Person getAllPerson(int id) {
		DbConnection dbc = new DbConnection();
		Connection connection = dbc.jdbcConnection();
		Person person = new Person();

		PreparedStatement ps = null;
		String selectQuery = ("select PERSON_ID,ACTIVE_IND,NAME_FIRST,NAME_LAST from PERSON where PERSON_ID = ?");
		try {
			ps = connection.prepareStatement(selectQuery);
			ps.setInt(1, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				person.setPersonId(rs.getInt("PERSON_ID"));
				person.setActiveInd(rs.getInt("ACTIVE_IND"));
				person.setNameFirst(rs.getString("NAME_FIRST"));
				person.setNameLast(rs.getString("NAME_LAST"));
				person.setStatus("SUCCESS");
			}

			System.out.println("Resultset : " + rs.getRow());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return person;
	}
}
