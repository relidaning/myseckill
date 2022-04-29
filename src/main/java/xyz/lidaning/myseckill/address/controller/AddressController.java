package xyz.lidaning.myseckill.address.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.lidaning.api.common.JsonResult;
import xyz.lidaning.myseckill.address.domain.Address;
import xyz.lidaning.myseckill.address.service.IAddressService;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/address/address")
public class AddressController{
    @Autowired
    private IAddressService addressService;

    @GetMapping("/list")
    public JsonResult list(Address address){
        List<Address> list = addressService.selectAddressList(address);
        return JsonResult.success(list);
    }

    @GetMapping(value = "/{id}")
    public JsonResult getInfo(@PathVariable("id") String id){
        return JsonResult.success(addressService.selectAddressById(id));
    }

    @PostMapping
    public JsonResult add(@RequestBody Address address){
        return JsonResult.success(addressService.insertAddress(address));
    }

    @PutMapping
    public JsonResult edit(@RequestBody Address address){
        return JsonResult.success(addressService.updateAddress(address));
    }

    @DeleteMapping
    public JsonResult remove(@PathVariable String[] ids){
        return JsonResult.success(addressService.deleteAddressByIds(ids));
    }

    @GetMapping("/insert100MData2Address")
    public JsonResult insert100MData2Address(){

        for(int i=0; i<16; i++){
            new Thread(()->{
                for (int j=0; j<12500000; j++){
                    Address address = new Address();
                    address.setId(UUID.randomUUID().toString().replaceAll("-", ""));
                    address.setAlias("家");
                    address.setProvince("北京");
                    address.setCity("北京");
                    address.setTown("海淀");
                    address.setVillage("海悦梧桐苑");
                    address.setAddr("3号院1号楼102");
                    addressService.insertAddress(address);
                }
            }, "insert100MData2Address"+i).start();
        }
        return JsonResult.success();
    }


}
