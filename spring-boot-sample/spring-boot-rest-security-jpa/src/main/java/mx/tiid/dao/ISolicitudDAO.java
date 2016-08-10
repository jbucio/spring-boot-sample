package mx.tiid.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.tiid.model.Solicitud;

@Repository
public interface ISolicitudDAO extends CrudRepository<Solicitud, Integer> {
	
	 public List<Solicitud> findAll();
	
	 public Solicitud findOne(Integer id);
	 
	 public Solicitud save(Solicitud solicitud);
	 
	 public boolean exists(Integer id);
	 
	 public Solicitud findByNumeroTelefonico(String numero);

}
