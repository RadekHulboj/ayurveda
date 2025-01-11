package eu.hulboj.Ayurveda.services;

import eu.hulboj.Ayurveda.entities.Location;
import eu.hulboj.Ayurveda.repositories.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class LocationService {
    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public Location getAllLocationById(Long id) {
        return locationRepository.findAll()
                .stream()
                .filter(location -> Objects.equals(location.getId(), id))
                .findFirst()
                .orElse(getAllLocations().get(0));
    }

    public void saveAll(List<Location> locations) {
        locationRepository.saveAll(locations);
    }
}