package com.br;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Essa é a anotação principal do Spring Boot.
// Ela já engloba várias configurações importantes automaticamente,
// como a configuração do projeto, a varredura de componentes e o auto-config.
@SpringBootApplication
public class BackendQuadraFacilApplication {

	// Método principal da aplicação (ponto de entrada do sistema)
	public static void main(String[] args) {

		// Aqui é onde a aplicação realmente começa a rodar.
		// O Spring Boot inicializa todo o contexto da aplicação,
		// organiza as dependências e sobe o servidor embutido (Tomcat),
		// permitindo que a API fique disponível para uso.
		SpringApplication.run(BackendQuadraFacilApplication.class, args);
	}

}