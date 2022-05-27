package htw.berlin.webtech.WebTech.web;

import htw.berlin.webtech.WebTech.service.PlantService;
import htw.berlin.webtech.WebTech.web.api.Plant;
import htw.berlin.webtech.WebTech.web.api.PlantCreateManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class PlantRestController {


    public PlantRestController(PlantService plantService) {
        this.plantService = plantService;
    }

    private final PlantService plantService;



    @GetMapping(path = "/api/v1/plant")
    public ResponseEntity<List<Plant>> fetchPlants() {
        return ResponseEntity.ok(plantService.findAll());

    }

    @GetMapping(path = "/api/v1/plant/{id}")
    public ResponseEntity<Plant> fetchPlantId(@PathVariable Long id){
        var plant = plantService.findById(id);
        return plant != null?ResponseEntity.ok(plant): ResponseEntity.notFound().build();

    }
    @PostMapping(path = "api/v1/plant")
    public ResponseEntity<Void> createPlant(@RequestBody PlantCreateManipulationRequest request) throws URISyntaxException {
 var plant = plantService.create(request);
 URI uri = new URI("api/v1/plant" + plant.getId());
return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "api/v1/plant/{id}")
    public ResponseEntity<Plant> updatePlant(@PathVariable Long id, @RequestBody PlantCreateManipulationRequest request) {
        var plant = plantService.update(id, request);
        return plant != null?ResponseEntity.ok(plant): ResponseEntity.notFound().build();

    }
    @DeleteMapping(path = "api/v1/plant/{id}")
    public ResponseEntity<Void> deletePlant(@PathVariable Long id) {
        boolean successful = plantService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
