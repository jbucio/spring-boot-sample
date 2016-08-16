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

import mx.tiid.model.db1.CuentasRevisar;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories( 
		entityManagerFactoryRef = "entityManagerFactory", 
basePackages = { "mx.tiid.dao.db1" })
public class ConfigDB1DataSources {


	@Primary 
	@Bean(name = "dataSource")
	@ConfigurationProperties(prefix = "datasource.db1")
	public DataSource primaryDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean db1EntityManagerFactory(EntityManagerFactoryBuilder builder,@Qualifier("dataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages(CuentasRevisar.class).persistenceUnit("db1").build();
	}
	
	@Primary
	@Bean(name = "transactionManager")
	 public PlatformTransactionManager db1TransactionManager(@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory){
		return new JpaTransactionManager(entityManagerFactory);
	}
	
	
}
