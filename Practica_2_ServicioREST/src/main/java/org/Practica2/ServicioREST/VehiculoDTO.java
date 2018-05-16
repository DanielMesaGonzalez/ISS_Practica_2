package org.Practica2.ServicioREST;

import java.sql.Timestamp;
import java.util.Date;

public class VehiculoDTO {

	int registro;
	int parkingId;
	String matricula;
	Timestamp TimeStamp;
	
	
	
	public VehiculoDTO(int parkingId, String matricula, Timestamp timeStamp) {
		super();
		this.parkingId = parkingId;
		this.matricula = matricula;
		TimeStamp = timeStamp;
	}
	public VehiculoDTO() {
		super();
	}
	public VehiculoDTO(int registro, int parkingId, String matricula, Timestamp timeStamp) {
		super();
		this.registro = registro;
		this.parkingId = parkingId;
		this.matricula = matricula;
		TimeStamp = timeStamp;
	}
	public int getRegistro() {
		return registro;
	}
	public void setRegistro(int registro) {
		this.registro = registro;
	}
	public int getParkingId() {
		return parkingId;
	}
	public void setParkingId(int parkingId) {
		this.parkingId = parkingId;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public Timestamp getTimeStamp() {
		return TimeStamp;
	}
	public void setTimeStamp(Timestamp timeStamp) {
		TimeStamp = timeStamp;
	}   
	
	
}