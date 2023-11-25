package com.example.Lab3D.initializer;

import com.example.Lab3D.nationality.mappers.NationalityMapper;
import com.example.Lab3D.nationality.services.NationalityService;
import com.example.Lab3D.player.entities.Player;
import com.example.Lab3D.player.mappers.PlayerMapper;
import com.example.Lab3D.player.services.PlayerService;
import jakarta.annotation.PostConstruct;

import com.example.Lab3D.nationality.entities.Nationality;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DataInitializer {
    private final PlayerMapper playerMapper;
    private final NationalityService nationalityService;
    private final PlayerService playerService;

    @PostConstruct
    public void initData() {
        System.out.println("Inicjalizacja danych rozpoczeta");

        Nationality nationality1 = Nationality.builder()
                .id(UUID.fromString("278b8fb4-ad4f-43fd-85e6-744b16b890c6"))
                .build();

        Nationality nationality2 = Nationality.builder()
                .id(UUID.fromString("a215d998-2c69-4965-a5bc-6715af939b2e"))
                .build();

        Nationality nationality3 = Nationality.builder()
                .id(UUID.fromString("dfcf0c3b-2d53-4b29-9a04-c496e0ea4d5e"))
                .build();

        Nationality nationality4 = Nationality.builder()
                .id(UUID.fromString("e126d265-75d4-4427-9059-88a209449510"))
                .build();

        nationalityService.save(nationality1);
        nationalityService.save(nationality2);
        nationalityService.save(nationality3);
        nationalityService.save(nationality4);



        Player player1 = Player.builder()
                .id(UUID.fromString("9f127ebe-5d44-4692-a39d-dc970d69415c"))
                .abilities(70)
                .name("Piotr")
                .nationality(nationality1)
                .build();

        Player player2 = Player.builder()
                .id(UUID.fromString("17830033-0cb4-4efd-83ad-e7b666be618a"))
                .abilities(75)
                .name("Pawel")
                .nationality(nationality1)
                .build();

        playerService.save(playerMapper.playerToPlayerDto(player1));
        playerService.save(playerMapper.playerToPlayerDto(player2));
        //nationality1.getPlayerList().add(player1);

        Player player3 = Player.builder()
                .id(UUID.fromString("862adb50-9e09-47e4-b0e9-7f2fce0beabf"))
                .abilities(65)
                .name("Janek")
                .nationality(nationality2)
                .build();

        Player player4 = Player.builder()
                .id(UUID.fromString("6583e443-9f47-458e-8916-f238c4716a10"))
                .abilities(60)
                .name("Oskar")
                .nationality(nationality2)
                .build();

        playerService.save(playerMapper.playerToPlayerDto(player3));
        playerService.save(playerMapper.playerToPlayerDto(player4));

        Player player5 = Player.builder()
                .id(UUID.fromString("740f0cb2-5c94-443a-82c6-599c657f75ae"))
                .abilities(80)
                .name("Kacper")
                .nationality(nationality3)
                .build();

        Player player6 = Player.builder()
                .id(UUID.fromString("e6af2800-f8c3-44c5-a235-33edf8297b12"))
                .abilities(50)
                .name("Michal")
                .nationality(nationality3)
                .build();

        playerService.save(playerMapper.playerToPlayerDto(player5));
        playerService.save(playerMapper.playerToPlayerDto(player6));

        Player player7 = Player.builder()
                .id(UUID.fromString("37535f41-8fc7-41dd-9283-8ba52cf7b50d"))
                .abilities(99)
                .name("Konrad")
                .nationality(nationality4)
                .build();

        Player player8 = Player.builder()
                .id(UUID.fromString("b452da60-8674-4420-b6af-efb874db4af6"))
                .abilities(87)
                .name("Mariusz")
                .nationality(nationality4)
                .build();

        playerService.save(playerMapper.playerToPlayerDto(player7));
        playerService.save(playerMapper.playerToPlayerDto(player8));

        System.out.println("Inicjalizacja danych zakonczona");
    }

    private void initPlayers() {

    }

    private void initNationalities() {


        System.out.println("Narodowości zainicjalizowane");
    }
}
