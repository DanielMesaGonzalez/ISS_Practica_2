package org.Practica2.ServicioREST;

import java.util.List;


public interface VehiculoDAOInterface {
	public void VehiculoNuevo(VehiculoDTO vehiculo);
	public List<VehiculoDTO> leeVehiculo();
	public VehiculoDTO BuscarVehiculo(int matricula);
}
