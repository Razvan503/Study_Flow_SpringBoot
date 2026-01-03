package org.example.study.Models.Register;

public class RegisterRequest {
    private String email;
    private String username;
    private String fullname;
    private String password;

    public RegisterRequest(String email, String username, String fullname, String password){
        this.email = email;
        this.username = username;
        this.fullname = fullname;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFullname() {
        return fullname;
    }

    public String getUsername() {
        return username;
    }
}
