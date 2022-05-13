package htw.berlin.webtech.WebTech.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantRepository extends JpaRepository<PlantEntity, Long> {
    List<PlantEntity> findAllByCommonName(String commonName);
}
