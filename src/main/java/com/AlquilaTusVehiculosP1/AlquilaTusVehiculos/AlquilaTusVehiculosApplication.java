package com.AlquilaTusVehiculosP1.AlquilaTusVehiculos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlquilaTusVehiculosApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlquilaTusVehiculosApplication.class, args);
	}

}


/*   docker build -t alquilatusvehiculos:latest .    */
/*   docker run -p 8080:8080 alquilatusvehiculos:latest   */
