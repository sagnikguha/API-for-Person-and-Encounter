package com.cerner.restapi.testingdemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EncounterDTO {

	public Encounter getEncounterById(long id){
		DbConnection dbConnectionEncounter = new DbConnection();
		Connection connection = dbConnectionEncounter.jdbcConnection();
		Encounter encounterInformation = new Encounter();
		PreparedStatement ps = null ;
		String query = ("select ACTIVE_IND,ENCNTR_ID,ENCNTR_TYPE_CD,REG_DT_TM,DISCH_DT_TM from ENCOUNTER where ENCNTR_ID = ?");
		try {
			ps = connection.prepareStatement(query);
			ps.setLong(1, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				encounterInformation.setActiveInd(rs.getInt("ACTIVE_IND"));
				encounterInformation.setEncntrId(rs.getLong("ENCNTR_ID"));
				encounterInformation.setEncntrTypeCd(rs.getLong("ENCNTR_TYPE_CD"));
				encounterInformation.setRegistrationDate(rs.getDate("REG_DT_TM"));
				encounterInformation.setDischargeDate(rs.getDate("DISCH_DT_TM"));
				encounterInformation.setStatus("SUCCESS");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return encounterInformation;
	}
}
