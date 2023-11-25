package com.example.Lab3D.nationality.mappers;

import com.example.Lab3D.nationality.entities.Nationality;
import com.example.Lab3D.nationality.model.NationalityDTO;
import org.mapstruct.Mapper;

@Mapper
public interface NationalityMapper {
    Nationality nationalityDtoToNationality(NationalityDTO dto);
    NationalityDTO nationalityToNationalityDto(Nationality nationality);
}
