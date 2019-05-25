package org.test.SpringBootApp.configuration;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class JdbcTemplateConfig {
	
	@Autowired
	private DatabaseConfig databaseConfig;
	
	@Bean
	public DataSource dataSource() {
	DataSource dataSource = new DataSource(); 
	dataSource.setDriverClassName(databaseConfig.getDriverClassName()); 	
	dataSource.setUrl(databaseConfig.getUrl());	
	dataSource.setUsername(databaseConfig.getUsername());
	dataSource.setPassword(databaseConfig.getPassword());
	return dataSource;

	}
	
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		
		 JdbcTemplate jdbcTempate = new JdbcTemplate();
		 jdbcTempate.setDataSource(dataSource());
		 return jdbcTempate;
		 
		
		
	}
	
	
	
	
	

}
