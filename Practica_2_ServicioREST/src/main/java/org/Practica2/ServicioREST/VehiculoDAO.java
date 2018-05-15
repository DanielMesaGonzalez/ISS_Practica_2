package org.Practica2.ServicioREST;

import java.util.List;

import javax.sql.DataSource;

import org.Practica2.ServicioREST.VehiculoMapper;
import org.Practica2.ServicioREST.VehiculoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class VehiculoDAO implements VehiculoDAOInterface {

	private JdbcTemplate jdbcTemplate;
		
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	    this.jdbcTemplate = jdbcTemplate;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
	this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
    @Override
	public void VehiculoNuevo(VehiculoDTO vehiculo) {
    	String sql = "insert into vehiculos values(?,?,?,?)";
		Object[ ] parametros = {vehiculo.getRegistro(), vehiculo.getParkingID(), vehiculo.getMatricula(), vehiculo.getTimeStamp()};
		this.jdbcTemplate.update(sql,parametros);
	}
    
	@Override
	public List<VehiculoDTO> listaVehiculo(){
		String sql= "select * from vehiculos";
		VehiculoMapper mapper= new VehiculoMapper();
		@SuppressWarnings("unchecked")
		List<VehiculoDTO> vehiculo= this.jdbcTemplate.query(sql, mapper);
		return vehiculo;
		
	}
	
	@Override
	public VehiculoDTO BuscarVehiculo(String matricula, int parkingid) {
		String sql = "select * from vehiculos where matricula = ? and parkingid = ?";
		Object[] parametros = {matricula,parkingid};   //Array de objetos
		VehiculoMapper mapper = new VehiculoMapper();
		List<VehiculoDTO> vehiculo = this.jdbcTemplate.query(sql, parametros, mapper);
		if (vehiculo.isEmpty()) return null;
		else return vehiculo.get(0);
		
	}
}
