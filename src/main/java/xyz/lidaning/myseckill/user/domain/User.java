package xyz.lidaning.myseckill.user.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{

    private static final long serialVersionUID = 1L;


    private int id;

    private String username;

    private String password;



    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }


    @Override
    public String toString() {

        return new StringBuilder("")
            .append("id:" + getId()+" ")
            .append("username:" + getUsername()+" ")
            .append("password:" + getPassword()+" ")
            .toString();
    }
}