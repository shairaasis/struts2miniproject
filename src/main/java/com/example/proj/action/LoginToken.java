package com.example.proj.action;

import java.io.Console;

import com.opensymphony.xwork2.ActionSupport;

public class LoginToken extends ActionSupport{
    private String token;

    public String execute() throws Exception {

        if(token != ""){ 
            System.out.println("\n\n TOKEN:... " +getToken());
            return "success";  
        }  
        else{  
            return "error";  
        } 
    }
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
}
