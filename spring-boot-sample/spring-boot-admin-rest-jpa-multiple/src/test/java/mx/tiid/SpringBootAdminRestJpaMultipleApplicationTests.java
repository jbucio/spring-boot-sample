package mx.tiid;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import mx.tiid.dao.db1.ICuentasRevisarDAO;
import mx.tiid.dao.db2.ISolicitudDAO;
import mx.tiid.model.db1.CuentasRevisar;
import mx.tiid.model.db2.Solicitud;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootAdminRestJpaMultipleApplicationTests {

	@Autowired
	private ICuentasRevisarDAO cuentasRevisarRepository;
	
	@Autowired
	private ISolicitudDAO solicitudRepository;

	@Test
	public void contextLoads() {
		
	List<CuentasRevisar> list = cuentasRevisarRepository.findAll();
	
	System.out.println(list.get(0).getCuenta());
	
	Assert.assertNotNull("Lisat de Actividades Vacia", list);
	}
	
	@Test
	public void contextLoads2() {
		
	List<Solicitud> solicitudes = solicitudRepository.findAll();
	
	System.out.println(solicitudes.get(0).getIdSolicitud());
	Assert.assertNotNull("Lista de solicitudes Vacia", solicitudes);
	}
	
	@Test
	public void contextLoads3() {
		
	Solicitud solicitud = solicitudRepository.find(199);
	
	System.out.println(solicitud.getIdSolicitud());
	System.out.println(solicitud.getRealizadas().getIdLote());
	System.out.println(solicitud.getRecibidas().getIdLote());
	Assert.assertNotNull("Solicitud Vacia", solicitud);
	Assert.assertNotNull("Realizadas Vacia", solicitud.getRealizadas());
	}


}
