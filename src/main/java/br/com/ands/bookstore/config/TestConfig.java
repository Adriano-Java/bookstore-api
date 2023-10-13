package br.com.ands.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.ands.bookstore.services.DBService;

/**
 * 
 * @author Adriano Neto Da Silva
 * @date 24 de jun. de 2021
 * @project bookstore
 */
@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBService dbService;
	
	@Bean
	public void instanciaBasedeDados() {
		this.dbService.instanciaBaseDeDados();
	}

}
