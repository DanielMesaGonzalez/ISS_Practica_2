package org.Practica2.ServicioREST;

import java.util.Date;

public class VehiculoDTO {

	int Registro;
	int ParkingID;
	String Matricula;
	Date TimeStamp;   
	
	
	public VehiculoDTO(int registro, int parkingID, String matricula, Date timeStamp) {
		this.Registro = registro;
		this.ParkingID = parkingID;
		this.Matricula = matricula;
		this.TimeStamp = timeStamp;
	}
	
	
	
	public VehiculoDTO(int parkingID, String matricula, Date timeStamp) {
		ParkingID = parkingID;
		Matricula = matricula;
		TimeStamp = timeStamp;
	}



	public VehiculoDTO() {
		Registro=0;
		ParkingID=0;
		Matricula="";
		TimeStamp=null;
	}


	public int getRegistro() {
		return Registro;
	}
	public void setRegistro(int registro) {
		Registro = registro;
	}
	public int getParkingID() {
		return ParkingID;
	}
	public void setParkingID(int parkingID) {
		ParkingID = parkingID;
	}
	public String getMatricula() {
		return Matricula;
	}
	public void setMatricula(String matricula) {
		Matricula = matricula;
	}
	public Date getTimeStamp() {
		return TimeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		TimeStamp = timeStamp;
	}
	
	
}
