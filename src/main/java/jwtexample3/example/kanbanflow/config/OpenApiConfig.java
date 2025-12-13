package jwtexample3.example.kanbanflow.config; // Adjust package name if necessary

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    // CORRECTED: Use a simple, descriptive name for the scheme
    private static final String SECURITY_SCHEME_NAME = "Bearer Authentication";
    
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                // 1. Define the security scheme (Header type, name, format)
                .components(new Components().addSecuritySchemes(
                                SECURITY_SCHEME_NAME,
                                new SecurityScheme()
                                        .name(SECURITY_SCHEME_NAME)
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                        )
                )
                // 2. Apply the security scheme globally to all endpoints
                .addSecurityItem(new SecurityRequirement().addList(SECURITY_SCHEME_NAME))

                // 3. General API Information
                .info(new Info()
                        .title("KanbanFlow REST API")
                        .version("1.0.0")
                        .description("Interactive documentation for the KanbanFlow application services.")
                        .contact(new Contact()
                                .name("Trello Kanban Team")
                                .email("support@kanbanflow.com")
                        )
                );
    }
}