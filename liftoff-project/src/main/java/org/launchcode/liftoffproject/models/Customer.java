package org.launchcode.liftoffproject.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer extends AbstractEntity {

    @NotBlank(message = "Please provide a valid email.")
    @Email
    private String email;

    @OneToMany
    @JoinColumn
    private List<Vendor> favoriteVendors = new ArrayList<>();

    public Customer(String email) {
        super();
        this.email = email;
    }

    public Customer() {}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Vendor> getFavoriteVendors() {
        return favoriteVendors;
    }

    public void addVendorToFavorites(Vendor vendor) {
        favoriteVendors.add(vendor);
    }

}
