package com.recap.carrental.core.security;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.security.SecuritySchemes;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Cem",
                        email = "cemguven4108@gmail.com",
                        url = "https://cemguven4108.com/"
                ),
                description = "API Implementation For Car Rental Managing System",
                title = "OpenApi Specs - CEMBO",
                version = "1.0",
                license = @License(
                        name = "License name",
                        url = "https://url.com"
                ),
                termsOfService = "Terms of Service"
        ),
        security = {
                @SecurityRequirement(
                        name = "jwtAuth"
                )
        }
)
@SecuritySchemes({
        @SecurityScheme(
                name = "jwtAuth",
                description = "JWT Auth Description",
                scheme = "Bearer",
                type = SecuritySchemeType.HTTP,
                bearerFormat = "JWT",
                in = SecuritySchemeIn.HEADER
        )
})
public class OpenApiConfiguration {}
