package eu.hulboj.Ayurveda.repositories;

import eu.hulboj.Ayurveda.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}