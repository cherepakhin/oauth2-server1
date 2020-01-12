package v.perm.ru.autserver1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;

@Configuration
public class AuthorizationServerConfig extends
		AuthorizationServerConfigurerAdapter {

	@Bean
	PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	// ClientId и ClientSecret можно убрать из application.yml
	@Override
	public void configure(
			ClientDetailsServiceConfigurer clients) throws Exception {
		clients
				.inMemory()
				.withClient("vasiid")
				.secret(passwordEncoder().encode("vasisecret"))
				.scopes("resource:read")
				.authorizedGrantTypes("authorization_code")
				.redirectUris("http://localhost:8081/oauth/login/client-app");
	}
}