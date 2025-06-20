package com.hms.payload;

import java.lang.String;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TokenDto {
    private String token;
    private  String type;

 //getter
    public  String getToken()  {
        return token;
    }
    //setter
    public  void setToken(String token) {
  this.token = token;
    }

    //getter
    public  String getType(){
        return type;
    }

    //setter
    public  void setType(String type) {
        this.type = type;
    }

}
