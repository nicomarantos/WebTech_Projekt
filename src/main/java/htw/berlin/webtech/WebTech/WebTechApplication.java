package htw.berlin.webtech.WebTech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static htw.berlin.webtech.WebTech.service.PlantService.calculateWateringperiodCurrent;

@SpringBootApplication
public class WebTechApplication {

	public static void main(String[] args) {
		calculateWateringperiodCurrent ();
		SpringApplication.run(WebTechApplication.class, args);
	}

}
