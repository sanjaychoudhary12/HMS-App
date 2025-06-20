package com.hms.payload;


import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
public class LoginDto {
    private String username;
    private String password;

//Getter
    public  String getUsername(){
        return username;
    }
//setter
    public void setUsername(String username){
this.username = username;
    }

    //getter
    public  String getPassword(){
        return password;
    }

    //setter
    public void setPassword(String password){
        this.password = password;
    }
}
