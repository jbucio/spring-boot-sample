package mx.tiid.dao.db1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.tiid.model.db1.Actividad;

public interface IActividadDAO extends JpaRepository<Actividad, String> {
	
	public List<Actividad> findAll();

}
