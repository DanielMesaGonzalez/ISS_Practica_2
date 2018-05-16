package org.Practica2.ServicioREST;

import java.sql.Timestamp;
import java.util.List;


public interface VehiculoDAOInterface {
	public void VehiculoNuevo(VehiculoDTO vehiculo);
	public List<VehiculoDTO> listaVehiculo();
	public VehiculoDTO BuscarVehiculo(String matricula, int parkingid);
	void updateVehiculo(String matricula, int parkingid);
	public Timestamp obtenerTimestamp();
}
