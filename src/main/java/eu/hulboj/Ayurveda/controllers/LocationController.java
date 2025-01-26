package eu.hulboj.Ayurveda.controllers;

import eu.hulboj.Ayurveda.entities.Location;
import eu.hulboj.Ayurveda.services.LocationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
@CrossOrigin(origins = "${ayurveda.allowed.cross.origin}")
public class LocationController {
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public List<Location> getAllLocations() {
        return locationService.getAllLocations();
    }

    @GetMapping("/{id}")
    public Location getLocationById(@PathVariable Long id) {
        return locationService.getAllLocationById(id);
    }
}