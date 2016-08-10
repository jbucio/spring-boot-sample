package mx.tiid;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import mx.tiid.dao.db1.IActividadDAO;
import mx.tiid.dao.db2.ISolicitudDAO;
import mx.tiid.model.db1.Actividad;
import mx.tiid.model.db2.Solicitud;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootAdminRestJpaMultipleApplicationTests {

	@Autowired
	private IActividadDAO actividadRepository;
	
	@Autowired
	private ISolicitudDAO solicitudRepository;

	@Test
	public void contextLoads() {
		
	List<Actividad> actividades = actividadRepository.findAll();
	
	System.out.println(actividades.get(0).getIdActividad());
	
	Assert.assertNotNull("Lisat de Actividades Vacia", actividades);
	}
	
	@Test
	public void contextLoads2() {
		
	List<Solicitud> solicitudes = solicitudRepository.findAll();
	
	System.out.println(solicitudes.get(0).getIdSolicitud());
	Assert.assertNotNull("Lisat de solicitudes Vacia", solicitudes);
	}

}
