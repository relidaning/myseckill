package xyz.lidaning.myseckill.address.service;

import xyz.lidaning.myseckill.address.domain.Address;

import java.util.List;

public interface IAddressService{

    public Address selectAddressById(String id);

    public List<Address> selectAddressList(Address address);

    public int insertAddress(Address address);

    public int updateAddress(Address address);

    public int deleteAddressByIds(String[] ids);

    public int deleteAddressById(String id);
}
