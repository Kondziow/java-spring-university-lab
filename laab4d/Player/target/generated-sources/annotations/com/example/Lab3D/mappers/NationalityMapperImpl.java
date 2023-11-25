package com.example.Lab3D.mappers;

import com.example.Lab3D.nationality.entities.Nationality;
import com.example.Lab3D.nationality.model.GetNationalityResponse;
import com.example.Lab3D.model.PutNationalityRequest;
import com.example.Lab3D.model.dto.NationalityDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;

import com.example.Lab3D.nationality.mappers.NationalityMapper;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-31T14:37:43+0100",
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
        nationality.name( dto.getName() );
        if ( dto.getAverageHeight() != null ) {
            nationality.averageHeight( dto.getAverageHeight() );
        }

        return nationality.build();
    }

    @Override
    public GetNationalityResponse nationalityDtoToGetNationalityResponse(NationalityDTO nationality) {
        if ( nationality == null ) {
            return null;
        }

        GetNationalityResponse.GetNationalityResponseBuilder getNationalityResponse = GetNationalityResponse.builder();

        getNationalityResponse.id( nationality.getId() );
        getNationalityResponse.name( nationality.getName() );
        getNationalityResponse.averageHeight( nationality.getAverageHeight() );
        List<UUID> list = nationality.getPlayers();
        if ( list != null ) {
            getNationalityResponse.players( new ArrayList<UUID>( list ) );
        }

        return getNationalityResponse.build();
    }

    @Override
    public Nationality putNationalityRequestToNationality(PutNationalityRequest putNationalityRequest) {
        if ( putNationalityRequest == null ) {
            return null;
        }

        Nationality.NationalityBuilder nationality = Nationality.builder();

        nationality.name( putNationalityRequest.getName() );
        nationality.averageHeight( putNationalityRequest.getAverageHeight() );

        return nationality.build();
    }
}
