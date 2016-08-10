package mx.tiid.config.datasource;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import mx.tiid.model.db1.Actividad;
import mx.tiid.model.db2.Solicitud;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "secondEntityManagerFactory", basePackages = { "mx.tiid.dao.db2" })
public class ConfigDB2DataSources {

	@Bean(name = "secondDataSource")
	@ConfigurationProperties(prefix = "datasource.db2")
	public DataSource secondDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "secondEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean db2EntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("secondDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages(Solicitud.class).persistenceUnit("db2").build();
	}

	@Bean(name = "secondTransactionManager")
	public PlatformTransactionManager db2TransactionManager(
			@Qualifier("secondEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

}
