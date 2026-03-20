package com.pushan.restapis.Employee_address.Service;

import com.pushan.restapis.Employee_address.DTO.AddressDTO;

import java.util.List;

public interface AddressService {
    AddressDTO updateAddress(int id, AddressDTO addressDTO);
    List<AddressDTO> getAllAddress();
    AddressDTO getAddressById(int id);
    void deleteAddress(int id);
}
