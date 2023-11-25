package com.example.Lab3D.player.services;

import com.example.Lab3D.player.model.dto.PlayerDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PlayerService {
    List<PlayerDTO> findAllByNationalityId(UUID uuid);
    PlayerDTO save(PlayerDTO player);
    List<PlayerDTO > findAll();
    Optional<PlayerDTO> findById(UUID id);
    boolean updateById(UUID id, PlayerDTO player);
    boolean deleteById(UUID id);
}
