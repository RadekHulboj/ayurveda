package eu.hulboj.Ayurveda.services;

import eu.hulboj.Ayurveda.entities.Location;
import eu.hulboj.Ayurveda.repositories.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public void saveAll(List<Location> locations) {
        locationRepository.saveAll(locations);
    }
}