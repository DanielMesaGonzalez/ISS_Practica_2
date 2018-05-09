package org.Practica2.ServicioREST;

public class VehiculosDTO {

	int Registro;
	int ParkingID;
	String Matricula;
	int TimeStamp;   //Revisar porque es formato fecha
	
	
	public VehiculosDTO(int registro, int parkingID, String matricula, int timeStamp) {
		super();
		Registro = registro;
		ParkingID = parkingID;
		Matricula = matricula;
		TimeStamp = timeStamp;
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
