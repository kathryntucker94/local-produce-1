package org.launchcode.liftoffproject.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product extends AbstractEntity {

    @NotBlank(message = "Please select product type.")
    private String type;

    @Size(max = 500, message = "Product description must not exceed 500 characters.")
    private String description;

    @Size(max = 200000)
    private String photo;

    //@NotBlank(message = "Please select whether or not product is organic.")
    private boolean organic;

    @ManyToOne
    @JoinColumn(name = "vendor_id", nullable = false)
    private Vendor vendor;

    public Product(String type, String description, String photo, boolean organic, Vendor vendor) {
        super();
        this.type = type;
        this.description = description;
        this.photo = photo;
        this.organic = organic;
        this.vendor = vendor;
    }

    public Product() {}


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public boolean isOrganic() {
        return organic;
    }

    public void setOrganic(boolean organic) {
        this.organic = organic;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }
}
