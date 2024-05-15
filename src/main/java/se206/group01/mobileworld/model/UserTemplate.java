package se206.group01.mobileworld.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UserTemplate {
    @NotBlank(message = "Username must not be empty")
    private String username;

    @NotBlank(message = "First name must not be empty")
    private String fname;
    
    @NotBlank(message = "Last name must not be empty")
    private String lname;

    @NotBlank(message = "Email must not be empty")
    private String email;

    @NotBlank(message = "Password must not be empty")
    private String password;

    @NotBlank(message = "Confirm password must not be empty")
    private String confirmPassword;

    @NotBlank(message = "Address must not be empty")
    private String address;

    @NotNull(message = "Date of birth must not be empty")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

    @NotBlank(message = "Phone must not be empty")
    private String phone;

    public UserTemplate() {

    }

    public UserTemplate(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.fname = user.getFname();
        this.lname = user.getLname();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.address = user.getAddress();
        this.dob = user.getDob();
        this.phone = user.getPhone();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
