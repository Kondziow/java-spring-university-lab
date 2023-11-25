package com.example.Lab3D.nationality.mappers;

import com.example.Lab3D.nationality.entities.Nationality;
import com.example.Lab3D.nationality.model.GetNationalityResponse;
import com.example.Lab3D.nationality.model.PutNationalityRequest;
import com.example.Lab3D.nationality.model.dto.NationalityDTO;
import org.mapstruct.Mapper;

@Mapper
public interface NationalityMapper {
    Nationality nationalityDtoToNationality(NationalityDTO dto);

    //NationalityDTO nationalityToNationalityDto(Nationality nationality);
    GetNationalityResponse nationalityDtoToGetNationalityResponse(NationalityDTO nationality);
    //GetNationalityResponse nationalityToGetNationalityResponse(Nationality nationality);
    Nationality putNationalityRequestToNationality(PutNationalityRequest putNationalityRequest);

    default NationalityDTO nationalityToNationalityDto(Nationality nationality) {
        if (nationality == null) {
            return null;
        } else {
            NationalityDTO.NationalityDTOBuilder nationalityDTO = NationalityDTO.builder();
            nationalityDTO.id(nationality.getId());
            nationalityDTO.name(nationality.getName());
            nationalityDTO.averageHeight(nationality.getAverageHeight());
            //nationalityDTO.players(nationality.getPlayerList().stream().map(Player::getId).toList());
            return nationalityDTO.build();
        }
    }
}
