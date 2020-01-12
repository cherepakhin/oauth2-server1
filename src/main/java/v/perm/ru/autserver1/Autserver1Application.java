package v.perm.ru.autserver1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@EnableAuthorizationServer
@SpringBootApplication
public class Autserver1Application {

	public static void main(String[] args) {
		SpringApplication.run(Autserver1Application.class, args);
	}

}
