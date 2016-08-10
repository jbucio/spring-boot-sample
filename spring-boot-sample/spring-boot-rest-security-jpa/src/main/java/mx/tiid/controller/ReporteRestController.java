package mx.tiid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.tiid.model.Solicitud;
import mx.tiid.service.ISolicitudService;

@RestController
@RequestMapping("/solicitudes")
public class ReporteRestController {
	
	@Autowired
	private ISolicitudService solicitudService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Solicitud>> getAll() {
	
		List<Solicitud> solicitudes = solicitudService.getAll();

		if(solicitudes.isEmpty()){
			return new ResponseEntity<List<Solicitud>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Solicitud>>(solicitudes, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}")
	public ResponseEntity<Solicitud> getById(@PathVariable int id) {
		
		Solicitud solicitud = solicitudService.getById(id); 

		if(solicitud == null){
			return new ResponseEntity<Solicitud>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Solicitud>(solicitud, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Solicitud> insert(@RequestBody Solicitud solicitud) {

		Solicitud solicitudResponse = solicitudService.save(solicitud);
		
		return new ResponseEntity<Solicitud>(solicitudResponse, HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Solicitud> update(@RequestBody Solicitud solicitud) {

		Solicitud solicitudResponse;
		try {
			solicitudResponse = solicitudService.update(solicitud);
		} catch (Exception e) {
			return new ResponseEntity<Solicitud>(HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<Solicitud>(solicitudResponse, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/phone/{number}")
	public ResponseEntity<Solicitud> getByPhoneNumber(@PathVariable String number) {
		
		Solicitud solicitud = solicitudService.getByPhoneNumber(number); 

		if(solicitud == null){
			return new ResponseEntity<Solicitud>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Solicitud>(solicitud, HttpStatus.OK);
	}

}
