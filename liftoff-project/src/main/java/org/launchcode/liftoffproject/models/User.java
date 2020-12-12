package org.launchcode.liftoffproject.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class User  {


    @Id
    @GeneratedValue
    private int id;

        @OneToOne
        @JoinColumn(name = "vendor_id")
        private Vendor vendor;

        @OneToOne
        @JoinColumn(name="CUSTOMER_ID")
        private Customer customer;

        @NotNull
        private String username;

        @NotNull
        private String pwHash;

        private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        public User() {}

        public User(String username, String password) {
            this.username = username;
            this.pwHash = encoder.encode(password);
        }

        public String getUsername() {
            return username;
        }


    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }

    public int getId() {
        return id;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}