package xyz.lidaning.myseckill.order.domain;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
public class Goods implements Serializable{

    private static final long serialVersionUID = 1L;

    private String id;

    private String goodsname;

    private Float price;

    private String isseckill;

    private String describ;

}
