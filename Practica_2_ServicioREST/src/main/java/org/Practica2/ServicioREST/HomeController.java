package org.Practica2.ServicioREST;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping(value ="registroMatricula/enviar", method = RequestMethod.POST)
	public ResponseEntity<VehiculoDTO> nuevo(@RequestBody VehiculoDTO vehiculo,Model model)  {
		int parkingId= vehiculo.getParkingId();
		String matricula=vehiculo.getMatricula();
		Timestamp timestamp=dao.obtenerTimestamp();
		vehiculo.setTimeStamp(timestamp);
		
		ResponseEntity<VehiculoDTO> respuestaHTTP=new ResponseEntity<VehiculoDTO>(vehiculo, HttpStatus.OK);
		
		if (dao.BuscarVehiculo(matricula,parkingId)==null) {
			        			    
			    dao.VehiculoNuevo(vehiculo);
			    respuestaHTTP=new ResponseEntity<VehiculoDTO>(vehiculo, HttpStatus.CREATED);
			
		}else
			dao.updateVehiculo(matricula, parkingId);
		return respuestaHTTP;
	
		}
	
	@RequestMapping(value ="/coste/{matricula}", method = RequestMethod.GET)
	public @ResponseBody String coste(@PathVariable(value="matricula") String matricula, Model model) {
	
	String precio="";
	if(dao.BuscarVehiculo(matricula, 0)!=null && dao.BuscarVehiculo(matricula, 1)!=null) {
	Timestamp timestampEntrada=dao.BuscarVehiculo(matricula,0).getTimeStamp();
	Timestamp timestampSalida=dao.BuscarVehiculo(matricula, 1).getTimeStamp();
	
	double tiempo = ((timestampSalida.getTime()-timestampEntrada.getTime())/1000)/60;
	double tarifa= 0.05;
	double coste= tiempo*tarifa;
	precio=Double.toString(coste);
		return precio;
	}else
		return precio;
	
	}
	
	@RequestMapping(value ="/pago", method = RequestMethod.GET)
	public String comprueba(Model model) {
	
		
		return "testcoste";
	}
	
	
}
