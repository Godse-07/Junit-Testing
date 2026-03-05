package com.pushan.Mapper;

import com.pushan.DTO.EmployeeDTO;
import com.pushan.Entity.EmployeeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);
    EmployeeDTO toDTO(EmployeeEntity entity);
    EmployeeEntity toEntity(EmployeeDTO dto);
}
