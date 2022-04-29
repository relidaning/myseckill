package xyz.lidaning.myseckill.address.service.impl;

import org.springframework.stereotype.Service;
import xyz.lidaning.myseckill.address.domain.Address;
import xyz.lidaning.myseckill.address.mapper.AddressMapper;
import xyz.lidaning.myseckill.address.service.IAddressService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AddressServiceImpl implements IAddressService{
    @Resource
    private AddressMapper addressMapper;

    @Override
    public Address selectAddressById(String id){
        return addressMapper.selectAddressById(id);
    }

    @Override
    public List<Address> selectAddressList(Address address){
        return addressMapper.selectAddressList(address);
    }

    @Override
    public int insertAddress(Address address){
        return addressMapper.insertAddress(address);
    }

    @Override
    public int updateAddress(Address address){
        return addressMapper.updateAddress(address);
    }

    @Override
    public int deleteAddressByIds(String[] ids){
        return addressMapper.deleteAddressByIds(ids);
    }

    @Override
    public int deleteAddressById(String id){
        return addressMapper.deleteAddressById(id);
    }
}
