package htw.berlin.webtech.WebTech.web;

import htw.berlin.webtech.WebTech.web.api.Plant;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PlantRestController {

    private List<Plant> plants;

    public PlantRestController() {
        plants = new ArrayList<>();
        plants.add(new Plant(1, "Fensterblatt", "Monstera Deliciosa", true));
        plants.add(new Plant(2, "Maranta Tricolor", "Maranta Leuconeura", false));

    }

    @GetMapping(path = "/epi/v1/plant")
    public ResponseEntity<List<Plant>> fetchPlants() {
        return ResponseEntity.ok(plants);

    }
}
