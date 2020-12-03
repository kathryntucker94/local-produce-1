package org.launchcode.liftoffproject.models;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer extends AbstractEntity {

    @NotBlank(message = "Please provide a valid email.")
    private Email email;

    private List<Vendor> favoriteVendors = new ArrayList<>();

    public Customer(Email email) {
        super();
        this.email = email;
    }

    public Customer() {}

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public List<Vendor> getFavoriteVendors() {
        return favoriteVendors;
    }

    public void addVendorToFavorites(Vendor vendor) {
        favoriteVendors.add(vendor);
    }

}
