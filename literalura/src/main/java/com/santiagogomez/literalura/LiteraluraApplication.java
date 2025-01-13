package com.santiagogomez.literalura;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.santiagogomez.literalura.principal.Principal;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.pruebaAPI();

	}

}

/*spring.datasource.url=jdbc:postgresql://${DB_HOST}/${DB_BOOKS}
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}
 */
