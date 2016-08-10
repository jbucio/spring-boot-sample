package mx.tiid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import mx.tiid.model.db1.Actividad;

@SpringBootApplication
@EnableAutoConfiguration
public class SpringBootAdminRestJpaMultipleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAdminRestJpaMultipleApplication.class, args);
	}

}
