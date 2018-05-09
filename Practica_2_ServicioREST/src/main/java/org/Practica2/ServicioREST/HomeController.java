package org.Practica2.ServicioREST;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.Practica2.ServicioREST.VehiculoDAOInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	private VehiculoDAOInterface dao;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "home";
	}
	
	@RequestMapping(value ="/registroMatricula", method = RequestMethod.GET)
		public String registro(HttpServletRequest request, Locale locale, Model model) {
		HttpSession sesion = request.getSession();
		Date timestamp = new Date();
		String respuesta="";
		String matricula = request.getParameter("Matricula");   //recojo de la peticion 
		int parkingid=Integer.parseInt(request.getParameter("ParkingID")); 
		VehiculoDTO vehiculo= new VehiculoDTO(parkingid, matricula, timestamp);  //meto en el objeto vehiculo los parametros (simplificas lo de meter set)

		if (dao.BuscarVehiculo(vehiculo.getMatricula(), vehiculo.getParkingID())==null) {
			        			    
			    sesion.setAttribute("nvehiculo", vehiculo);
			    request.setAttribute("nvehiculo", vehiculo);
			    dao.VehiculoNuevo(vehiculo);	
			
		}
		
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		if (parkingid==0) {    //si recibimos un "0" para la barrera de entrada 
			respuesta="Barrera de entrada";
		}
		else   
			respuesta="Barrera de salida";           //En caso contrario (recibimos un 1) estamos en la barrera de salida
			++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		
		
		return null;
		}
	
	
}
