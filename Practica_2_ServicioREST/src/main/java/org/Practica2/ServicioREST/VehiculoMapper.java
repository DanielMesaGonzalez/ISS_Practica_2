package org.Practica2.ServicioREST;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class VehiculoMapper implements RowMapper<VehiculoDTO>{

		public VehiculoDTO mapRow(ResultSet rs, int rowNum) throws SQLException{
			
	     VehiculoDTO vehiculo = new VehiculoDTO();
	     vehiculo.setRegistro(rs.getInt("Registro"));
	     vehiculo.setParkingID(rs.getInt("ParkingID"));
	     vehiculo.setMatricula(rs.getString("Matricula"));
	     vehiculo.setTimeStamp(rs.getInt("TimeStamp"));

	return vehiculo;
	}
}
