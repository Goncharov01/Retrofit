package com.example.retrofit;

import java.util.List;

public class UserLogin {

    private String id;
    private String login;
    private String password;
    private List<ModelMotos> motos;


    public UserLogin(String id, String login, String password, List<ModelMotos> motos) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.motos = motos;
    }

    public UserLogin(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ModelMotos> getMotos() {
        return motos;
    }

    public void setMotos(List<ModelMotos> motos) {
        this.motos = motos;
    }





}
