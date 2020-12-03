package org.launchcode.liftoffproject.models;

import javax.persistence.Entity;
import java.util.ArrayList;

@Entity
public class Customer extends AbstractEntity {

    private String email;
    private ArrayList<Integer> favoriteVendors;

    public Customer(String email, ArrayList<Integer> favoriteVendors) {
        super();
        this.email = email;
        this.favoriteVendors = new ArrayList<>();
    }

    public Customer() {}

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

}
