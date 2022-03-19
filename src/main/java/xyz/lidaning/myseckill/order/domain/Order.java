package xyz.lidaning.myseckill.order.domain;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {

    private static final long serialVersionUID = 1L;


    private int id;

    private int userid;

    private int goodsid;

    private int num;



    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid){
        this.userid = userid;
    }

    public int getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(int goodsid){
        this.goodsid = goodsid;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num){
        this.num = num;
    }


    @Override
    public String toString() {

        return new StringBuilder("")
            .append("id:" + getId()+" ")
            .append("userid:" + getUserid()+" ")
            .append("goodsid:" + getGoodsid()+" ")
            .append("num:" + getNum()+" ")
            .toString();
    }
}
