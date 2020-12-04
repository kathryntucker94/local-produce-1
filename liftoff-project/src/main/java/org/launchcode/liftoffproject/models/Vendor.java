package org.launchcode.liftoffproject.models;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Vendor extends AbstractEntity{

    @NotBlank(message = "Please provide a valid contact email.")
    private Email email;

    @NotBlank(message = "Please select a location.")
    private String location;

    @Size(max = 500, message = "Cannot exceed 500 characters.")
    private String bio;
    private String photo;
    private double averageRating;

    public Vendor(Email email, String location, String bio, String photo, double averageRating) {
        super();
        this.email = email;
        this.location = location;
        this.bio = bio;
        this.photo = photo;
        this.averageRating = averageRating;
    }

    public Vendor() {}

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }
}
