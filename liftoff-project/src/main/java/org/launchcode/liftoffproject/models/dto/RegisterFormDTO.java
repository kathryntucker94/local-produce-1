package org.launchcode.liftoffproject.models.dto;

import javax.persistence.Column;

public class RegisterFormDTO extends LoginFormDTO {

    private boolean isVendor = false;

    private String verifyPassword;

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }

    public boolean isVendor() {
        return isVendor;
    }
}