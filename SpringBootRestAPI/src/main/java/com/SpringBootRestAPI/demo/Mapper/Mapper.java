package com.SpringBootRestAPI.demo.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    private final ModelMapper modelMapper;
    public Mapper(ModelMapper mapper) {
        this.modelMapper = mapper;
    }
    public <D, T> D map(T entity, Class<D> outClass) {
        return modelMapper.map(entity, outClass);
    }
}
