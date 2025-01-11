package eu.hulboj.Ayurveda.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Location {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String city;
    private String state;
    private String photo;

    @Lob
    private String article;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(id, location.id) && Objects.equals(name, location.name) && Objects.equals(city, location.city) && Objects.equals(state, location.state) && Objects.equals(photo, location.photo) && Objects.equals(article, location.article);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, city, state, photo, article);
    }
}
