package br.com.sandes.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    OpenAPI customConfig() {
        return new OpenAPI()
                .info(new Info()
                        .title("User REST API")
                        .version("v1")
                        .description("Api responsavel pelo cadastro de usuarios")
                        .termsOfService("https://pub.sandes.com.br/user-api")
                        .license(
                                new License()
                                        .name("https://pub.sandes.com.br/user-api")
                        ));
    }
}
