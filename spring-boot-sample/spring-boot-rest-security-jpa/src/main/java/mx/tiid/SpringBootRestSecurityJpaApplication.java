package mx.tiid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@SpringBootApplication
@ComponentScan(basePackages = "mx.tiid")
@Configuration
@EnableAutoConfiguration
public class SpringBootRestSecurityJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestSecurityJpaApplication.class, args);
	}
	
	@Configuration
	@EnableGlobalMethodSecurity(prePostEnabled = true)
	@EnableWebSecurity
	static class SecurityConfiguration extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {

			auth.inMemoryAuthentication().
					withUser("user").password("user").roles("USER").and().
					withUser("admin").password("admin").roles("USER", "ADMIN");
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {

			http.httpBasic().and().authorizeRequests().
					antMatchers(HttpMethod.GET, "/solicitudes/**").hasRole("USER")
					.antMatchers(HttpMethod.GET, "/solicitudes").hasRole("USER")
					.antMatchers(HttpMethod.POST, "/solicitudes").hasRole("ADMIN")
					.antMatchers(HttpMethod.PUT, "/solicitudes").hasRole("ADMIN").and().csrf().disable();
		}
	}
}
