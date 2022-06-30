package htw.berlin.webtech.WebTech.service;

import htw.berlin.webtech.WebTech.persistence.PlantEntity;
import htw.berlin.webtech.WebTech.persistence.PlantRepository;
import htw.berlin.webtech.WebTech.web.api.Plant;
import htw.berlin.webtech.WebTech.web.api.PlantCreateManipulationRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlantService {

    private final PlantRepository plantRepository;

    public PlantService(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    public List<Plant> findAll() {
        List<PlantEntity> plants = plantRepository.findAll();
        return plants.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Plant findById(Long id) {
        var plantEntity = plantRepository.findById(id);
        return plantEntity.map(this::transformEntity).orElse(null);
    }

    public Plant create(PlantCreateManipulationRequest request) {
       var plantEntity =new PlantEntity(request.getCommonName(), request.getBotanicalName(),request.getDescription(), request.getWateringperiod(), request.getWateringperiodCurrent(), request.getDay(), request.isSaved());
        plantEntity = plantRepository.save(plantEntity);
        return transformEntity(plantEntity);

    }

    public Plant update(Long id, PlantCreateManipulationRequest request){
        var plantEntityOptional = plantRepository.findById(id);
        if (plantEntityOptional.isEmpty()) {
            return null;
        }
        var plantEntity = plantEntityOptional.get();
        plantEntity.setCommonName(request.getCommonName());
        plantEntity.setBotanicalName(request.getBotanicalName());
        plantEntity.setDescription(request.getDescription());
        plantEntity.setWateringperiod(request.getWateringperiod());
        plantEntity.setWateringperiodCurrent(request.getWateringperiodCurrent());
        plantEntity.setSaved(request.isSaved());
        plantEntity = plantRepository.save(plantEntity);
        return transformEntity(plantEntity);
    }

    public boolean deleteById(Long id) {
        if (!plantRepository.existsById(id)) {
            return false;
        }
        plantRepository.deleteById(id);
        return true;
    }

    private Plant transformEntity(PlantEntity plantEntity) {
        return new Plant(
                plantEntity.getId(),
                plantEntity.getCommonName(),
                plantEntity.getBotanicalName(),
                plantEntity.getDescription(),
                plantEntity.getWateringperiod(),
                plantEntity.getWateringperiodCurrent(),
                plantEntity.getDay(),
                plantEntity.getSaved()
        );

    }
    public static void calculateWateringperiodCurrent (){
        Integer currentDay = LocalDate.now().getDayOfYear();

    }
}
