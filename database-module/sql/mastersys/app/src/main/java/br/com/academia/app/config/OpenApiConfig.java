package br.com.academia.app.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfig {
 @Bean
 public OpenAPI customOpenAPI() {
  return new OpenAPI().info(new Info()
  .title("API Academia")
  .version("1.0.0")
  .description(
   """
    API para gerenciamento de academia que inclui:
    - Cadastro de alunos
    - Cadastro de instrutores
    - Cadastro de planos de treino
    - Registro de frequência de alunos
    - Geração de relatórios de desempenho
      
   """)
 .contact(new Contact()
  .name("dev Silva")
  .email("dev.silva@example.com")
  .url("https://github.com/dev-silva"))

 .license(new License()
  .name("Apache 2.0")
  .url("http://apache.org/licenses/LICENSE-2.0.html")))
  .servers(List.of(new Server()
  .url("http://localhost:8080")
  .description("Servidor local")))
  .externalDocs(new ExternalDocumentation()
   .description("Documentação do projeto")
   .url("https://github.com/dev-silva/academia-docs"));
 }
}
