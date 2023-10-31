package com.example.Lab3D.services;

import com.example.Lab3D.model.dto.PlayerDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PlayerService {
    PlayerDTO save(PlayerDTO player);
    List<PlayerDTO > findAll();
    Optional<PlayerDTO> findById(UUID id);
    void updateById(UUID id, PlayerDTO player);
    boolean deleteById(UUID id);
}
