package com.example.Lab3D.bootstrap;

import com.example.Lab3D.mappers.NationalityMapper;
import com.example.Lab3D.mappers.PlayerMapper;
import jakarta.annotation.PostConstruct;
import com.example.Lab3D.entities.Nationality;
import com.example.Lab3D.entities.Player;
import com.example.Lab3D.services.NationalityService;
import com.example.Lab3D.services.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DataInitializer {
    private static final String[] nationalityNames = {"Polska", "Szwecja", "Dania", "Australia"};
    private static final int[] nationalityHeights = {180, 170, 175, 185};
    private static final String[] playerNames = {"Konrad", "Kacper", "Janek", "Michal", "Oskar", "Artur", "Przemek", "Sebastian", "Sergiusz"};

    private final NationalityMapper nationalityMapper;
    private final PlayerMapper playerMapper;
    private final NationalityService nationalityService;
    private final PlayerService playerService;

    /*public DataInitializer(NationalityService nationalityService, PlayerService playerService) {
        this.nationalityService = nationalityService;
        this.playerService = playerService;
    }*/

    @PostConstruct
    public void initData() {
        System.out.println("Inicjalizacja danych rozpoczeta");
        Random random = new Random();

        for (int i = 0; i < nationalityHeights.length; i++) {
            Nationality nationality = Nationality.builder().id(UUID.randomUUID()).name(nationalityNames[i]).averageHeight(nationalityHeights[i]).build();
            Nationality savedNationality =nationalityMapper.nationalityDtoToNationality(nationalityService.save(nationalityMapper.nationalityToNationalityDto(nationality)));
            for(int j = 0; j < 4; j++) {
                Player player = Player.builder().id(UUID.randomUUID()).name(playerNames[random.nextInt(playerNames.length)]).abilities(random.nextInt(100)+1).nationality(savedNationality).build();
                nationality.getPlayerList().add(player);
                playerService.save(playerMapper.playerToPlayerDto(player));
            }
            nationalityService.save(nationalityMapper.nationalityToNationalityDto(nationality));
        }
        System.out.println("Inicjalizacja danych zakonczona");
    }
}
