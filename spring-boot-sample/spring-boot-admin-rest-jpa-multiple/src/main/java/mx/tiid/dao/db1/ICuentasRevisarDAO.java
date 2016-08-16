package mx.tiid.dao.db1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.tiid.model.db1.CuentasRevisar;

public interface ICuentasRevisarDAO extends JpaRepository<CuentasRevisar, String> {
	
	public List<CuentasRevisar> findAll();

}
