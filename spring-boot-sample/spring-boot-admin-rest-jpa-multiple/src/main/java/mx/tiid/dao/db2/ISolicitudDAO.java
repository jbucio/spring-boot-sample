package mx.tiid.dao.db2;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.tiid.model.db2.Solicitud;


@Repository
public interface ISolicitudDAO extends CrudRepository<Solicitud, Integer> {
	
	 public List<Solicitud> findAll();
	
	 public Solicitud findOne(Integer id);
	 
	 public Solicitud save(Solicitud solicitud);
	 
	 public boolean exists(Integer id);
	 
	 public Solicitud findByNumeroTelefonico(String numero);

}
