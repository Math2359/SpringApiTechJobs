package br.com.techjobs.api.techjobs.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class ConfigSwagger {
    @Bean
    public OpenAPI customApi(){
        return new OpenAPI().info(
            new Info().title("TechJobs").description("API do TechJobs").version("1")
        );
    }
}
