package xyz.lidaning.myseckill.order.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    private int userid;

    private int goodsid;

    private int num;

}
