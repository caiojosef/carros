package br.edu.uniara.lpi2.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class RestApplicationTests {

	@Autowired
	private RestApplication restApplication;

	@Test
	void contextLoads() {
		// Verifica se a aplicação Spring Boot foi carregada corretamente
		assertNotNull(restApplication);
	}
}
