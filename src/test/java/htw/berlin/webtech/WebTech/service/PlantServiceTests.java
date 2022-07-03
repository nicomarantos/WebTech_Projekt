package htw.berlin.webtech.WebTech.service;


import htw.berlin.webtech.WebTech.persistence.PlantEntity;
import htw.berlin.webtech.WebTech.persistence.PlantRepository;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.Mockito;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.mockito.Mockito.*;

@SpringBootTest
class PlantServiceTests implements WithAssertions {

    @Mock
    private PlantRepository testRepo;

    @InjectMocks
    private PlantService forTesting;


    @Test
    @DisplayName("should transform PlantEntitiy to Plant")
    void should_transform_plant_entity_to_plant() {
        // given
        var plantEntitiy = Mockito.mock(PlantEntity.class);
        doReturn(1L).when(plantEntitiy).getId();
        doReturn("Monstera").when(plantEntitiy).getCommonName();
        doReturn("Monstera Deliciosa").when(plantEntitiy).getBotanicalName();
        doReturn("its a plant.").when(plantEntitiy).getDescription();
        doReturn(10).when(plantEntitiy).getWateringperiod();
        doReturn(10).when(plantEntitiy).getWateringperiodCurrent();
        doReturn(100).when(plantEntitiy).getDay();
        doReturn(false).when(plantEntitiy).getSaved();

        //when
        var result = forTesting.transformEntity(plantEntitiy);

        //then
        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getCommonName()).isEqualTo("Monstera");
        assertThat(result.getBotanicalName()).isEqualTo("Monstera Deliciosa");
        assertThat(result.getDescription()).isEqualTo("its a plant.");
        assertThat(result.getWateringperiod()).isEqualTo(10);
        assertThat(result.getWateringperiodCurrent()).isEqualTo(10);
        assertThat(result.getDay()).isEqualTo(100);
        assertThat(result.isSaved()).isEqualTo(false);
    }

    @Test
    @DisplayName("")
    void should_return_true_if_delete_was_successful(){
        //given
        Long givenID = 1L;
        doReturn(true).when(testRepo).existsById(givenID);

        //when
        boolean result = forTesting.deleteById(givenID);

        //then
        verify(testRepo).deleteById(givenID);
        assertThat(result).isTrue();


    }


    @Test
    @DisplayName("")
    void should_return_false_if_person_to_delete_does_not_exist(){
        //given
        Long givenID = 100L;
        doReturn(false).when(testRepo).existsById(givenID);

        //when
        boolean result = forTesting.deleteById(givenID);

        //then
        assertThat(result).isFalse();
    }


}
