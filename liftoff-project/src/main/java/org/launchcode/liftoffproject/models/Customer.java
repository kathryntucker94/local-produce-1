package org.launchcode.liftoffproject.models;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;

@Entity
public class Customer extends AbstractEntity {

    @NotBlank(message = "Please provide a valid email.")
    private Email email;


    private ArrayList<Integer> favoriteVendors;

    public Customer(Email email, ArrayList<Integer> favoriteVendors) {
        super();
        this.email = email;
        this.favoriteVendors = new ArrayList<>();
    }

    public Customer() {}

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public ArrayList<Integer> getFavoriteVendors() {
        return favoriteVendors;
    }

    public void setFavoriteVendors(ArrayList<Integer> favoriteVendors) {
        this.favoriteVendors = favoriteVendors;
    }

}
