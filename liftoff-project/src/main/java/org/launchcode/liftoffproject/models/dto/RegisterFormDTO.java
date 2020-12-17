package org.launchcode.liftoffproject.models.dto;

public class RegisterFormDTO extends LoginFormDTO {

    private String isVendor;

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

    public String getIsVendor() {
        return isVendor;
    }

    public void setIsVendor(String isVendor) {
        this.isVendor = isVendor;
    }
}