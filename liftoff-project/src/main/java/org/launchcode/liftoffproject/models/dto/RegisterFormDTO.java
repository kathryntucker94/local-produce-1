package org.launchcode.liftoffproject.models.dto;

import javax.validation.constraints.NotNull;

public class RegisterFormDTO extends LoginFormDTO {

    private String userRole;

    private String verifyPassword;

    private String verifyEmail;

    public String getVerifyEmail() {
        return verifyEmail;
    }

    public void setVerifyEmail(String verifyEmail) { this.verifyEmail = verifyEmail; }

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
}