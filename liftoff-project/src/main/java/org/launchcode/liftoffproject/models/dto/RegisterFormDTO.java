package org.launchcode.liftoffproject.models.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RegisterFormDTO extends LoginFormDTO {


    private String isVendor;

    private String verifyPassword;

    @NotNull
    @NotBlank
    @Email
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }

    public String getIsVendor() {
        return isVendor;
    }

    public void setIsVendor(String isVendor) {
        this.isVendor = isVendor;
    }
}