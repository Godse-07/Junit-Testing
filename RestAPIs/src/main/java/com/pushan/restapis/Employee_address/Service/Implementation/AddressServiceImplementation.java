package com.pushan.restapis.Employee_address.Service.Implementation;

import com.pushan.restapis.Employee_address.DTO.AddressDTO;
import com.pushan.restapis.Employee_address.Entity.AddressEntity;
import com.pushan.restapis.Employee_address.Mapper.Mapper;
import com.pushan.restapis.Employee_address.Repository.AddressRepository;
import com.pushan.restapis.Employee_address.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImplementation implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public AddressDTO updateAddress(int id, AddressDTO addressDTO) {

        AddressEntity addressEntity = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found with id: " + id));

        if (addressDTO.getStreet() != null) {
            addressEntity.setStreet(addressDTO.getStreet());
        }

        if (addressDTO.getCity() != null) {
            addressEntity.setCity(addressDTO.getCity());
        }

        if (addressDTO.getState() != null) {
            addressEntity.setState(addressDTO.getState());
        }

        if (addressDTO.getCountry() != null) {
            addressEntity.setCountry(addressDTO.getCountry());
        }

        if (addressDTO.getPincode() != null) {
            addressEntity.setPincode(addressDTO.getPincode());
        }

        AddressEntity updated = addressRepository.save(addressEntity);
        return mapper.map(updated, AddressDTO.class);
    }

    @Override
    public List<AddressDTO> getAllAddress() {
        return addressRepository.findAll()
                .stream()
                .map(addressEntity -> mapper.map(addressEntity, AddressDTO.class))
                .toList();
    }

    @Override
    public AddressDTO getAddressById(int id) {
        AddressEntity addressEntity = addressRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Address not found with id: " + id));
        return mapper.map(addressEntity, AddressDTO.class);
    }

    @Override
    public void deleteAddress(int id) {
        addressRepository.deleteById(id);
    }
}
