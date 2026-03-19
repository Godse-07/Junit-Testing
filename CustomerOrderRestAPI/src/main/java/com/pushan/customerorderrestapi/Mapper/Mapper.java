package com.pushan.customerorderrestapi.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    private final ModelMapper modelMapper;
    public Mapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public <D, T> D map(T entity, Class<D> outClass) {
        return modelMapper.map(entity, outClass);
    }
}
