package org.launchcode.liftoffproject.models;

import javax.persistence.Entity;

@Entity
public class Vendor extends AbstractEntity{

    private String location;
    private String bio;
    private String photo;

    public Vendor(String location, String bio, String photo) {
        super();
        this.location = location;
        this.bio = bio;
        this.photo = photo;
    }

    public Vendor() {}

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
}
