package org.example.study.Models.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountDTO {
    @JsonProperty("username")
    private String username;

    @JsonProperty("email")
    private String email;

    @JsonProperty("fullname")
    private String fullname;

    public AccountDTO(String username,String email,String fullname){
        this.username = username;
        this.email = email;
        this.fullname = fullname;
    }


    @JsonProperty("username")
    public String getUsername(){
        return username;
    }

   @JsonProperty("email")
    public String getEmail(){
        return email;
   }

   @JsonProperty("fullname")
    public String getFullname(){
        return email;
   }


    @JsonProperty("fullname")
    public void setUsername(String username){
        this.username = username;
    }

    @JsonProperty("username")
    public void setFullname(String fullname){
        this.fullname = fullname;
    }

    @JsonProperty("email")
    public void setEmail(String email){
        this.email = email;
    }
}
