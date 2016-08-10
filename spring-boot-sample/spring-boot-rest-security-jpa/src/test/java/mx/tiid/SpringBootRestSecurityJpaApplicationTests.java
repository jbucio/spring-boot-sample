package mx.tiid;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import mx.tiid.model.Solicitud;
import mx.tiid.service.ISolicitudService;
import mx.tiid.service.impl.SolicitudServiceImpl;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class SpringBootRestSecurityJpaApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	private ISolicitudService solicitudService;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .build();
		this.solicitudService = Mockito.mock(SolicitudServiceImpl.class);
	}
	

	@Test
	public void testFindAllFromMVC() throws Exception {	
		 mockMvc.perform(get("/solicitudes"))
         .andExpect(status().isOk())
         .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));

	}
	
	@Test
	public void testFindAllFromService() throws Exception {	
		
		List<Solicitud> solicitudes = solicitudService.getAll();
		Assert.assertNotNull("El objeto no puede ir vacio", solicitudes);

	}

}
