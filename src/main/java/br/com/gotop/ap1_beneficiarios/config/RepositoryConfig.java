package br.com.gotop.ap1_beneficiarios.config;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

/**
 * @author Luis Inserra
 *
 * 19 de dez. de 2023 13:42:32
 */
@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactoryBenef", basePackages = "br.com.gotop.ap1_beneficiarios.repository")
public class RepositoryConfig {
	
	public void setAmbiente() {
		System.out.println("Setando ambiente...");
		
		System.setProperty("spring.config.name", "config");
		System.setProperty("server.port", "3306");
		System.setProperty("spring.jpa.database", "MYSQL");
		System.setProperty("spring.datasource.jdbc-url", "jdbc:mysql://localhost/tivia?useTimezone=true&serverTimezone=UTC");
	}

	@Primary
	@Bean(name = "datasourceBeneficiarios")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		setAmbiente();
		return DataSourceBuilder.create().build();
	}
	
	@Primary
	@Bean(name = "entityManagerFactoryBenef")
	@ConfigurationProperties(prefix = "spring")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("datasourceBeneficiarios") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("br.com.gotop.ap1_beneficiarios.model")
				.persistenceUnit("spring").build();
	}

}
