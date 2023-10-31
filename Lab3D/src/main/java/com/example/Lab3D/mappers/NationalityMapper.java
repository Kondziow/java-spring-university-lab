package com.example.Lab3D.mappers;

import com.example.Lab3D.entities.Nationality;
import com.example.Lab3D.model.GetNationalityResponse;
import com.example.Lab3D.model.PutNationalityRequest;
import com.example.Lab3D.model.dto.NationalityDTO;
import org.mapstruct.Mapper;

@Mapper
public interface NationalityMapper {
    Nationality nationalityDtoToNationality(NationalityDTO dto);

    NationalityDTO nationalityToNationalityDto(Nationality nationality);
    GetNationalityResponse nationalityDtoToGetNationalityResponse(NationalityDTO nationality);
    Nationality putNationalityRequestToNationality(PutNationalityRequest putNationalityRequest);
}
