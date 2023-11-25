package com.example.Lab3D.player.repositories;

import com.example.Lab3D.player.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PlayerRepository extends JpaRepository<Player, UUID> {
    //List<Player> findAllByNationalityId(UUID uuid);
    List<Player> findByNationality_Id(UUID uuid);
}
