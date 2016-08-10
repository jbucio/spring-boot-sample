package mx.tiid.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.tiid.dao.ISolicitudDAO;
import mx.tiid.model.Solicitud;
import mx.tiid.service.ISolicitudService;

@Service
public class SolicitudServiceImpl implements ISolicitudService {

	@Autowired
	private ISolicitudDAO solicitudRepository;
	
	@Override
	public List<Solicitud> getAll() {
		return solicitudRepository.findAll();
	}

	@Override
	public Solicitud getById(int id) {
		return solicitudRepository.findOne(id);
	}

	@Override
	public Solicitud save(Solicitud solicitud) {
		return solicitudRepository.save(solicitud);

	}

	@Override
	public Solicitud update(Solicitud solicitud) throws Exception {
		
		if(solicitudRepository.exists(solicitud.getIdSolicitud())){
			return solicitudRepository.save(solicitud);
		}
		
		throw new Exception();

	}

	@Override
	public Solicitud getByPhoneNumber(String numero) {
		return solicitudRepository.findByNumeroTelefonico(numero);
	}

}
