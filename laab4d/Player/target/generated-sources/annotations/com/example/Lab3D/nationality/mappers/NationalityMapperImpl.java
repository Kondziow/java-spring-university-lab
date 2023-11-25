package com.example.Lab3D.nationality.mappers;

import com.example.Lab3D.nationality.entities.Nationality;
import com.example.Lab3D.nationality.model.NationalityDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-13T19:24:33+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class NationalityMapperImpl implements NationalityMapper {

    @Override
    public Nationality nationalityDtoToNationality(NationalityDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Nationality.NationalityBuilder nationality = Nationality.builder();

        nationality.id( dto.getId() );

        return nationality.build();
    }

    @Override
    public NationalityDTO nationalityToNationalityDto(Nationality nationality) {
        if ( nationality == null ) {
            return null;
        }

        NationalityDTO.NationalityDTOBuilder nationalityDTO = NationalityDTO.builder();

        nationalityDTO.id( nationality.getId() );

        return nationalityDTO.build();
    }
}
