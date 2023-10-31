package com.example.Lab3D.mappers;

import com.example.Lab3D.entities.Player;
import com.example.Lab3D.model.GetPlayerResponse;
import com.example.Lab3D.model.PutPlayerRequest;
import com.example.Lab3D.model.dto.PlayerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface PlayerMapper {
    Player playerDtoToPlayer(PlayerDTO dto);

    PlayerDTO playerToPlayerDto(Player player);
    GetPlayerResponse playerDtoToGetPlayerResponse(PlayerDTO player);
    Player putPlayerRequestToPlayer(PutPlayerRequest putPlayerRequest);
}
