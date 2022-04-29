package xyz.lidaning.myseckill.order.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Goods implements Serializable{

    private static final long serialVersionUID = 1L;

    private int id;

    private String goodsname;

    private Float price;

    private String isseckill;

    private String describ;

    private int store;


}
