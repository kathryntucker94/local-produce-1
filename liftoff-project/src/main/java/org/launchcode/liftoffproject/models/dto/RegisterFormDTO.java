package org.launchcode.liftoffproject.models.dto;

import javax.validation.constraints.NotNull;

public class RegisterFormDTO extends LoginFormDTO {

    private String userRole;

    private String isVendor;

    private String verifyPassword;

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getIsVendor() {
        return isVendor;
    }

    public void setIsVendor(String isVendor) {
        this.isVendor = isVendor;
    }
}