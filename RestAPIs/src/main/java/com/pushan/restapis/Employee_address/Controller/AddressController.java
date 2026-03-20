package com.pushan.restapis.Employee_address.Controller;

import com.pushan.restapis.Employee_address.DTO.AddressDTO;
import com.pushan.restapis.Employee_address.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PutMapping("/updateAddress/{id}")
    public AddressDTO updateAddress(@PathVariable int id, @RequestBody AddressDTO addressDTO) {
        return addressService.updateAddress(id, addressDTO);
    }

    @GetMapping("/getAllAddress")
    public List<AddressDTO> getAllAddress() {
        return addressService.getAllAddress();
    }

    @DeleteMapping("/addressDelete/{id}")
    public void deleteAddress(@PathVariable int id) {
        addressService.deleteAddress(id);
    }

}
