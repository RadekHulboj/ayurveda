package eu.hulboj.Ayurveda.entities;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class LocationList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Add an id field for the LocationList entity

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Location> locations;

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LocationList that = (LocationList) o;
        return Objects.equals(locations, that.locations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locations);
    }
}
