package com.pushan.restapis.Employee_address.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    @Autowired
    private ModelMapper mapper;

    public <D, T> D map(T entity, Class<D> outClass) {
        return mapper.map(entity, outClass);
    }
}
