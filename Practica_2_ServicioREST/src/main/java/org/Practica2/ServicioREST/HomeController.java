package org.Practica2.ServicioREST;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.Practica2.ServicioREST.VehiculoDAOInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private VehiculoDAOInterface dao;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "testparking";
	}
	
	@RequestMapping(value ="/registroMatricula", method = RequestMethod.POST)
	public ResponseEntity<VehiculoDTO> nuevo(@RequestBody VehiculoDTO vehiculo)  {
		int parkingId= vehiculo.getParkingID();
		String matricula=vehiculo.getMatricula();
		Date timestamp= new Date();
		ResponseEntity<VehiculoDTO> respuestaHTTP=new ResponseEntity<VehiculoDTO>(vehiculo, HttpStatus.FOUND);
		
		if (dao.BuscarVehiculo(vehiculo.getMatricula(), vehiculo.getParkingID())==null) {
			        			    
			    dao.VehiculoNuevo(vehiculo);
			    respuestaHTTP=new ResponseEntity<VehiculoDTO>(vehiculo, HttpStatus.CREATED);
			
		}
		
		
	/*	else if (dao.BuscarVehiculo(matricula, parkingId).getParkingID()==1) {
			return "testcoste";
		}
		*/
/*		if (dao.BuscarVehiculo(matricula, parkingId).getParkingID()==0) {    //si recibimos un "0" para la barrera de entrada 
			respuesta="Barrera de entrada";
		}
		else   
			respuesta="Barrera de salida";  */         //En caso contrario (recibimos un 1) estamos en la barrera de salida
		
		
		return respuestaHTTP;
	
		}
	
	@RequestMapping(value ="/coste", method = RequestMethod.GET)
	public String comprueba(HttpServletRequest request, Locale locale, Model model) {
	
		return "testcoste";
	}
	
	
	
}
