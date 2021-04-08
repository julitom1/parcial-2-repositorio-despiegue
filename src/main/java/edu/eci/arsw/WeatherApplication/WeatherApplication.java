package edu.eci.arsw.WeatherApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"edu.eci.arsw.WeatherBackend"})
public class WeatherApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherApplication.class, args);
	}

}
