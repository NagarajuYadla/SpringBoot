package spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@ComponentScan({"spring.service", "spring.service.serviceimplementation","spring.controller"})
@SpringBootApplication
public class SpringApplicationPostmantoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringApplicationPostmantoolApplication.class, args);
	}
	
	@Bean
	   public WebMvcConfigurer corsConfigurer() {
	      return new WebMvcConfigurerAdapter() {
	         @Override
	         public void addCorsMappings(CorsRegistry registry) {
	            registry.addMapping("/getAll").allowedOrigins("*");
	            registry.addMapping("/save").allowedOrigins("*");
	         }
	      };
	   }

}
