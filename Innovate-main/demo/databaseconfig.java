package com.example.demo;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
 
 
@Configuration
public class databaseconfig {
 
	@Bean
	public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/progetto");
        dataSource.setUsername("root");
        dataSource.setPassword("mapjyx-dUpruf-tympo2");
        return dataSource;
    }
 
}
