package xyz.lidaning.myseckill.address.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Address implements Serializable{

    private static final long serialVersionUID = 1L;

    private String id;

    private int userid;

    private String alias;

    private String province;

    private String city;

    private String town;

    private String village;

    private String addr;


}
