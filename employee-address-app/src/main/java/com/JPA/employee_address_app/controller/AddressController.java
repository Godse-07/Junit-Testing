package com.JPA.employee_address_app.controller;

import com.JPA.employee_address_app.entity.Address;
import com.JPA.employee_address_app.service.AddressService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {
    public final AddressService service;

    public AddressController(AddressService addressService) {
        this.service = addressService;
    }

    @PostMapping
    public Address save(@RequestBody Address address){
        return service.saveAddress(address);
    }

    @GetMapping("/{id}")
    public Address get(@PathVariable long id){
        return service.getAddressById(id);
    }

    @PutMapping("/{id}")
    public Address update(@PathVariable long id,
                          @RequestBody Address address){
        return service.update(id,address);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        service.delete(id);
    }
}
