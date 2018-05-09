package org.Practica2.ServicioREST;

public class VehiculoDTO {

	int Registro;
	int ParkingID;
	String Matricula;
	int TimeStamp;   //Revisar porque es formato fecha
	
	
	public VehiculoDTO(int registro, int parkingID, String matricula, int timeStamp) {
		this.Registro = registro;
		this.ParkingID = parkingID;
		this.Matricula = matricula;
		this.TimeStamp = timeStamp;
	}
	
	
	public VehiculoDTO() {
		Registro=0;
		ParkingID=0;
		Matricula="";
		TimeStamp=0;
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
	public int getTimeStamp() {
		return TimeStamp;
	}
	public void setTimeStamp(int timeStamp) {
		TimeStamp = timeStamp;
	}
	
	
}
