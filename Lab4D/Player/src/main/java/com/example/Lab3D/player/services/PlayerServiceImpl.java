package com.example.Lab3D.player.services;

//import com.example.Lab3D.player.mappers.NationalityMapper;
import com.example.Lab3D.nationality.entities.Nationality;
import com.example.Lab3D.player.mappers.PlayerMapper;
import com.example.Lab3D.player.model.dto.PlayerDTO;
import com.example.Lab3D.player.repositories.PlayerRepository;
import com.example.Lab3D.nationality.repositories.NationalityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;
    //private final NationalityMapper nationalityMapper;

    private final NationalityRepository nationalityRepository;

    @Override
    public List<PlayerDTO> findAllByNationalityId(UUID uuid) {
        return playerRepository.findByNationality_Id(uuid).stream()
                .map(playerMapper::playerToPlayerDto)
                .collect(Collectors.toList());
    }

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
        /*if(!nationalityRepository.existsById(player.getNationality().getId())) {
            return false;
        }*/

        player.setId(id);
        /*Optional<Nationality> nationality = nationalityRepository.findById(player.getNationality().getId());
        Nationality nationality1 = nationality.get();
        nationality1.getPlayerList().add(playerMapper.playerDtoToPlayer(player));*/
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
