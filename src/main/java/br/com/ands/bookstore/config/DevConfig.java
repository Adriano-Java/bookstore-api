package br.com.ands.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.ands.bookstore.services.DBService;

/**
 * Configuração para o perfil DEV
 * 
 * @author Adriano Neto Da Silva
 * @date 24 de jun. de 2021
 * @project bookstore
 */
@Configuration
@Profile("dev")
public class DevConfig {
	
	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean instaciarBancodeDadosH2() {
		if(strategy.equals("create")) {
			this.dbService.instanciaBaseDeDados();
		}
		return false;
	}

}
