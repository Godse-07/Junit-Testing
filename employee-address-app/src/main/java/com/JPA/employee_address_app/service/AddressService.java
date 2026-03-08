package com.JPA.employee_address_app.service;

import com.JPA.employee_address_app.entity.Address;
import com.JPA.employee_address_app.repository.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    // save address
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    // address update
    public Address update(long id, Address newAddress) {
        Address address = addressRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Address not found")
        );
        address.setStreet(newAddress.getStreet());
        address.setCity(newAddress.getCity());
        address.setState(newAddress.getState());
        address.setCountry(newAddress.getCountry());
        address.setPincode(newAddress.getPincode());
        return addressRepository.save(address);
    }

    // delete address
    public void delete(long id) {
        addressRepository.deleteById(id);
        System.out.println("Address deleted successfully");
    }

    // address by id
    public Address getAddressById(long id) {
        return addressRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Address not found")
        );
    }
}
