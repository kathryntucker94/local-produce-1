package org.launchcode.liftoffproject.models;

import javax.persistence.*;
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

//    @OneToOne(mappedBy="customer")
//    private User user;

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

    public String getUsername(User user) {
        return user.getUsername();
    }

}
