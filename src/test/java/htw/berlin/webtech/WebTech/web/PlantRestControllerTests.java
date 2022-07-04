package htw.berlin.webtech.WebTech.web;

import htw.berlin.webtech.WebTech.persistence.PlantEntity;
import htw.berlin.webtech.WebTech.persistence.PlantRepository;

import htw.berlin.webtech.WebTech.service.PlantService;
import htw.berlin.webtech.WebTech.web.api.Plant;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PlantRestController.class)
class PlantRestControllerTests{
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlantService testPlantService;

    @Test
    @DisplayName("should_return_found_plant_from_plant_service")
    void should_return_found_plant_from_plant_service() throws Exception {
        //given
        var plants = List.of(
          new Plant(1,"Monstera","Monstera Deliousa","Its a plant",10,10,100,false),
          new Plant(2,"Monstera2","Monstera Deliousa2","Its a plant2",11,11,101,false)
        );
        doReturn(plants).when(testPlantService).findAll();

        //when
        mockMvc.perform(get("/api/v1/plant"))

        //then
        .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].commonName").value("Monstera"))
                .andExpect(jsonPath("$[0].botanicalName").value("Monstera Deliousa"))
                .andExpect(jsonPath("$[0].description").value("Its a plant"))
                .andExpect(jsonPath("$[0].wateringperiod").value(10))
                .andExpect(jsonPath("$[0].wateringperiodCurrent").value(10))
                .andExpect(jsonPath("$[0].day").value(100))
                .andExpect(jsonPath("$[0].saved").value(false))
                .andExpect(jsonPath("$[1].commonName").value("Monstera2"))
                .andExpect(jsonPath("$[1].botanicalName").value("Monstera Deliousa2"))
                .andExpect(jsonPath("$[1].description").value("Its a plant2"))
                .andExpect(jsonPath("$[1].wateringperiod").value(11))
                .andExpect(jsonPath("$[1].wateringperiodCurrent").value(11))
                .andExpect(jsonPath("$[1].day").value(101))
                .andExpect(jsonPath("$[1].saved").value(false));
    }
    @Test
    @DisplayName("should_return_404_if_plant_is_not_found")
    void should_return_404_if_plant_is_not_found() throws Exception {
        //given
        doReturn(null).when(testPlantService).findById(anyLong());

        //when
        mockMvc.perform(get("/api/v1/plant/999"))

               //then
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("should_return_201_http_status_and_location_header_when_creating_a_plant")
    void should_return_201_http_status_and_location_header_when_creating_a_plant() throws Exception {
        //given
        String plantToCreateAsJson = "{\"commonName\": \"Monstera\", \"botanicalName\": \"Monstera Deliousa\", \"description\": \"Its a plant\", \"wateringperiod\": \"10\", \"wateringperiodCurrent\": \"10\", \"day\": \"100\", \"saved\": true}";
        var plant = new Plant(1,null,null,null,null,null,null,false);
        doReturn(plant).when(testPlantService).create(any());

        //when
        mockMvc.perform(
                post("/api/v1/plant")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(plantToCreateAsJson)
        )
                //then
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(header().string("Location", Matchers.containsString(Long.toString(plant.getId()))));
    }

    @Test
    @DisplayName("should_validate_create_plant_request")
    void should_validate_create_plant_request() throws Exception {
        //given
        String plantToCreateAsJson = "{\"commonName\": \"\", \"botanicalName\": \"\", \"description\": \"Its a plant\", \"wateringperiod\": \"test\", \"wateringperiodCurrent\": \"10\", \"day\": \"100\", \"saved\": true}";


        //when
        mockMvc.perform(
                        post("/api/v1/plant")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(plantToCreateAsJson)
                )
                //then
                .andExpect(status().isBadRequest());
    }




}
