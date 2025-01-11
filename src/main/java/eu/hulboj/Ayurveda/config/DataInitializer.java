package eu.hulboj.Ayurveda.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu.hulboj.Ayurveda.entities.Location;
import eu.hulboj.Ayurveda.entities.LocationList;
import eu.hulboj.Ayurveda.services.LocationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
public class DataInitializer {
    @Bean
    CommandLineRunner runner(LocationService locationService) {
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<LocationList> typeReference = new TypeReference<>() {};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/db.json");
            try {
                LocationList locationList = mapper.readValue(inputStream, typeReference);
                locationService.saveAll(locationList.getLocations());
                System.out.println("Dane zostały zaimportowane!");
            } catch (Exception e) {
                System.out.println("Nie udało się zaimportować danych: " + e.getMessage());
            }
        };
    }
}
