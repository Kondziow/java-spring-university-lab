package com.example.Lab3D.player.controllers;

import com.example.Lab3D.player.mappers.PlayerMapper;
import com.example.Lab3D.player.model.GetPlayerResponse;
import com.example.Lab3D.player.model.GetPlayersResponse;
import com.example.Lab3D.player.model.dto.PlayerDTO;
import com.example.Lab3D.player.services.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class PlayerController {
    public final String PLAYER_PATH = "/api/players";
    public final String PLAYER_PATH_ID = PLAYER_PATH + "/{playerId}";
    private final PlayerMapper playerMapper;
    private final PlayerService playerService;

    @GetMapping("/api/nationalities/{nationalityId}/players")
    public ResponseEntity<GetPlayersResponse> getAllByNationalityId(@PathVariable("nationalityId") UUID uuid) {
        return ResponseEntity.ok(GetPlayersResponse.builder()
                        .players(playerService.findAllByNationalityId(uuid).stream()
                                .map(playerMapper::playerDtoToGetPlayerResponse)
                                .collect(Collectors.toList()))
                .build());
    }

    @PutMapping(PLAYER_PATH_ID)
    public ResponseEntity<Void> updatePlayerById(@PathVariable("playerId")UUID id, @RequestBody PlayerDTO player) {
        if(!playerService.updateById(id, player)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(PLAYER_PATH_ID)
    public ResponseEntity<Void> deletePlayerById(@PathVariable("playerId") UUID id) {
        playerService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(PLAYER_PATH)
    public ResponseEntity<GetPlayersResponse> getAllPlayers() {
        return ResponseEntity.ok(GetPlayersResponse.builder()
                .players(playerService.findAll().stream()
                        .map(playerMapper::playerDtoToGetPlayerResponse)
                        .collect(Collectors.toList()))
                .build());
    }

    @GetMapping(PLAYER_PATH_ID)
    public ResponseEntity<GetPlayerResponse> getPlayerById(@PathVariable("playerId") UUID id) {
        return ResponseEntity.ok(playerService.findById(id)
                .map(playerMapper::playerDtoToGetPlayerResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }
}
