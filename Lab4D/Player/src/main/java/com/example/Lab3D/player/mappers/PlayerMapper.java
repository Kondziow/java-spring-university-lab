package com.example.Lab3D.player.mappers;

import com.example.Lab3D.player.entities.Player;
import com.example.Lab3D.player.model.GetPlayerResponse;
import com.example.Lab3D.player.model.PutPlayerRequest;
import com.example.Lab3D.player.model.dto.PlayerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface PlayerMapper {
    Player playerDtoToPlayer(PlayerDTO dto);

    PlayerDTO playerToPlayerDto(Player player);
    //GetPlayerResponse playerDtoToGetPlayerResponse(PlayerDTO player);

    default GetPlayerResponse playerDtoToGetPlayerResponse(PlayerDTO player) {
        if ( player == null ) {
            return null;
        }

        GetPlayerResponse.GetPlayerResponseBuilder getPlayerResponse = GetPlayerResponse.builder();

        getPlayerResponse.id( player.getId() );
        getPlayerResponse.name( player.getName() );
        getPlayerResponse.abilities( player.getAbilities() );
        //getPlayerResponse.nationality( player.getNationality() );


        return getPlayerResponse.build();
    }
    Player putPlayerRequestToPlayer(PutPlayerRequest putPlayerRequest);
}
