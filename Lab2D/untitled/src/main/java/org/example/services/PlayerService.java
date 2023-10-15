package org.example.services;

import org.example.entities.Player;

import java.util.List;
import java.util.UUID;

public interface PlayerService {
    Player save(Player player);
    List<Player> findAll();
    void deleteById(UUID id);
}
