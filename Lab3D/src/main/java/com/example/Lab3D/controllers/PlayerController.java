package com.example.Lab3D.controllers;

import com.example.Lab3D.mappers.PlayerMapper;
import com.example.Lab3D.model.GetPlayerResponse;
import com.example.Lab3D.model.GetPlayersResponse;
import com.example.Lab3D.model.dto.PlayerDTO;
import com.example.Lab3D.services.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PlayerController {
    public final String PLAYER_PATH = "/api/players";
    public final String PLAYER_PATH_ID = PLAYER_PATH + "/{customerId}";
    private final PlayerMapper playerMapper;
    private final PlayerService playerService;

    @PutMapping(PLAYER_PATH_ID)
    public ResponseEntity<Void> updatePlayerById(@PathVariable("customerId")UUID id, @RequestBody PlayerDTO player) {
        playerService.updateById(id, player);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(PLAYER_PATH_ID)
    public ResponseEntity<Void> deletePlayerById(@PathVariable("customerId") UUID id) {
        playerService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(PLAYER_PATH)
    public ResponseEntity<GetPlayersResponse> getAllPlayers() {
        return ResponseEntity.ok(GetPlayersResponse.builder()
                .players(playerService.findAll())
                .build());
    }

    @GetMapping(PLAYER_PATH_ID)
    public ResponseEntity<GetPlayerResponse> getPlayerById(@PathVariable("customerId") UUID id) {
        return ResponseEntity.ok(playerService.findById(id)
                //.map(playerMapper::playerDtoToPlayer)
                .map(playerMapper::playerDtoToGetPlayerResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }
}
