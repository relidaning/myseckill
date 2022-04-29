package xyz.lidaning.myseckill.address.mapper;

import org.apache.ibatis.annotations.Mapper;
import xyz.lidaning.myseckill.address.domain.Address;

import java.util.List;

@Mapper
public interface AddressMapper {

    public Address selectAddressById(String id);

    public List<Address> selectAddressList(Address address);

    public int insertAddress(Address address);

    public int updateAddress(Address address);

    public int deleteAddressById(String id);

    public int deleteAddressByIds(String[] ids);
}
