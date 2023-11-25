package com.example.Lab3D.services;

import com.example.Lab3D.mappers.NationalityMapper;
import com.example.Lab3D.mappers.PlayerMapper;
import com.example.Lab3D.model.dto.PlayerDTO;
import com.example.Lab3D.repositories.NationalityRepository;
import com.example.Lab3D.repositories.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;
    private final NationalityMapper nationalityMapper;

    private final NationalityRepository nationalityRepository;

    @Override
    public PlayerDTO save(PlayerDTO player) {
        return playerMapper.playerToPlayerDto(playerRepository.save(playerMapper.playerDtoToPlayer(player)));
    }

    @Override
    public List<PlayerDTO> findAll() {
        return playerRepository.findAll().stream()
                .map(playerMapper::playerToPlayerDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PlayerDTO> findById(UUID id) {
        return Optional.ofNullable(playerMapper.playerToPlayerDto(playerRepository.findById(id)
                .orElse(null)));
    }

    @Override
    public boolean updateById(UUID id, PlayerDTO player) {
        if(!nationalityRepository.existsById(player.getNationality().getId())) {
            return false;
        }

        player.setId(id);
        playerRepository.save(playerMapper.playerDtoToPlayer(player));
        return true;
    }

    @Override
    public boolean deleteById(UUID id) {
        if (playerRepository.existsById(id)) {
            playerRepository.deleteById(id);
            return true;
        }
        return false;

    }
}
