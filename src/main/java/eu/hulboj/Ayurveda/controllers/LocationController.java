package eu.hulboj.Ayurveda.controllers;

import eu.hulboj.Ayurveda.entities.Location;
import eu.hulboj.Ayurveda.services.LocationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
@CrossOrigin(origins = "${ayurveda.allowed.cross.origin}")
public class LocationController {

    @Value("${ayurveda.allowed.cross.origin}")
    private String allowedOrigin;

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public List<Location> getAllLocations() {
        System.out.println("CORS allowed origin: " + allowedOrigin);
        return locationService.getAllLocations();
    }

    @GetMapping("/{id}")
    public Location getLocationById(@PathVariable Long id) {
        System.out.println("CORS allowed origin: " + allowedOrigin);
        return locationService.getAllLocationById(id);
    }
}