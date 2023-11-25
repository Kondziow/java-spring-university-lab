package com.example.Lab3D.player.mappers;

import com.example.Lab3D.nationality.entities.Nationality;
import com.example.Lab3D.nationality.model.NationalityDTO;
import com.example.Lab3D.player.entities.Player;
import com.example.Lab3D.player.model.PutPlayerRequest;
import com.example.Lab3D.player.model.dto.PlayerDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-14T10:59:47+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class PlayerMapperImpl implements PlayerMapper {

    @Override
    public Player playerDtoToPlayer(PlayerDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Player.PlayerBuilder player = Player.builder();

        player.id( dto.getId() );
        player.name( dto.getName() );
        if ( dto.getAbilities() != null ) {
            player.abilities( dto.getAbilities() );
        }
        player.nationality( nationalityDTOToNationality( dto.getNationality() ) );

        return player.build();
    }

    @Override
    public PlayerDTO playerToPlayerDto(Player player) {
        if ( player == null ) {
            return null;
        }

        PlayerDTO.PlayerDTOBuilder playerDTO = PlayerDTO.builder();

        playerDTO.id( player.getId() );
        playerDTO.name( player.getName() );
        playerDTO.abilities( player.getAbilities() );
        playerDTO.nationality( nationalityToNationalityDTO( player.getNationality() ) );

        return playerDTO.build();
    }

    @Override
    public Player putPlayerRequestToPlayer(PutPlayerRequest putPlayerRequest) {
        if ( putPlayerRequest == null ) {
            return null;
        }

        Player.PlayerBuilder player = Player.builder();

        player.name( putPlayerRequest.getName() );
        if ( putPlayerRequest.getAbilities() != null ) {
            player.abilities( putPlayerRequest.getAbilities() );
        }

        return player.build();
    }

    protected Nationality nationalityDTOToNationality(NationalityDTO nationalityDTO) {
        if ( nationalityDTO == null ) {
            return null;
        }

        Nationality.NationalityBuilder nationality = Nationality.builder();

        nationality.id( nationalityDTO.getId() );

        return nationality.build();
    }

    protected NationalityDTO nationalityToNationalityDTO(Nationality nationality) {
        if ( nationality == null ) {
            return null;
        }

        NationalityDTO.NationalityDTOBuilder nationalityDTO = NationalityDTO.builder();

        nationalityDTO.id( nationality.getId() );

        return nationalityDTO.build();
    }
}
