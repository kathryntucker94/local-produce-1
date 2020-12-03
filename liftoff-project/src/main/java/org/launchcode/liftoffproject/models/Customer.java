package org.launchcode.liftoffproject.models;

import javax.persistence.Entity;
import java.util.ArrayList;

@Entity
public class Customer {

    private String name;
    private String email;
    private ArrayList<Integer> favoriteVendors;

    public Customer(String name, String email, ArrayList<Integer> favoriteVendors) {
        this.name = name;
        this.email = email;
        this.favoriteVendors = new ArrayList<>();
    }

    public Customer() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Integer> getFavoriteVendors() {
        return favoriteVendors;
    }

    public void setFavoriteVendors(ArrayList<Integer> favoriteVendors) {
        this.favoriteVendors = favoriteVendors;
    }

    @Override
    public String toString() {
        return name;
    }

}
