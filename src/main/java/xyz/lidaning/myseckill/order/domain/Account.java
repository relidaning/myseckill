package xyz.lidaning.myseckill.order.domain;

import java.io.Serializable;
import java.util.Date;

public class Account implements Serializable{

    private static final long serialVersionUID = 1L;


    private int id;

    private int userId;

    private Float reminder;



    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getUserid() {
        return userId;
    }

    public void setUserid(int userId){
        this.userId = userId;
    }

    public Float getReminder() {
        return reminder;
    }

    public void setReminder(Float reminder){
        this.reminder = reminder;
    }


    @Override
    public String toString() {

        return new StringBuilder("")
            .append("id:" + getId()+" ")
            .append("userId:" + getUserid()+" ")
            .append("reminder:" + getReminder()+" ")
            .toString();
    }
}