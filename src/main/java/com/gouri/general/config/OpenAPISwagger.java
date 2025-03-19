package com.gouri.general.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPISwagger {

    @Bean
    OpenAPI defineOpenAPIAttribute(){
        Server server = new Server();
        server.setUrl("http://localhost:8024/");
        server.setDescription("General Application Development Open API");

        Contact contact = new Contact();
        contact.setEmail("dilip.verma940805@gmail.com");
        contact.setName("General Open Source API Development");

        Info info = new Info();
        info.setContact(contact);
        info.setTitle("General Open Source API");
        info.setVersion("1.0");
        info.setDescription("Application is meant for general purpose development of including most of the Spring service features.");
        return new OpenAPI().info(info).servers(List.of(server));
    }
}
