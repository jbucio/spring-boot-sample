package mx.tiid.service;

import java.util.List;

import org.springframework.stereotype.Component;

import mx.tiid.model.Solicitud;

@Component
public interface ISolicitudService {

	public List<Solicitud> getAll();
	
	public Solicitud getById(int id);
	
	public Solicitud save(Solicitud solicitud);
	
	public Solicitud update(Solicitud solicitud) throws Exception;
	
	public Solicitud getByPhoneNumber(String numero);
}
