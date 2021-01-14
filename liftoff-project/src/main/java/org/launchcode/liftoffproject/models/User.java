package org.launchcode.liftoffproject.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User  {

    @Id
    @GeneratedValue
    private int id;

    @OneToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    @NotNull
    private String username;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String pwHash;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    private int userRole;

    public User() {}

    public User(String username,String email, String password, int userRole) {

        this.username = username;
        this.email = email;
        this.pwHash = encoder.encode(password);
        this.userRole = userRole;
    }

    public String getUsername() {
            return username;
        }

    public String getEmail() { return email;}

    public Boolean isMatchingPassword(String password) {
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

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int isVendor) {
        this.userRole = isVendor;
    }
}