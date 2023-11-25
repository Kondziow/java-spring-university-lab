package com.example.Lab3D.nationality.initializer;

import com.example.Lab3D.nationality.entities.Nationality;
import com.example.Lab3D.nationality.mappers.NationalityMapper;
import com.example.Lab3D.nationality.services.NationalityService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DataInitializer {
    private static final String[] nationalityNames = {"Polska", "Szwecja", "Dania", "Australia"};
    private static final int[] nationalityHeights = {180, 170, 175, 185};

    //private static final String[]
    //private static final String[] playerNames = {"Konrad", "Kacper", "Janek", "Michal", "Oskar", "Artur", "Przemek", "Sebastian", "Sergiusz"};

    private final NationalityMapper nationalityMapper;
    private final NationalityService nationalityService;

    @PostConstruct
    public void initData() {
        System.out.println("Inicjalizacja danych rozpoczeta");
        Nationality nationality1 = Nationality.builder()
                .id(UUID.fromString("278b8fb4-ad4f-43fd-85e6-744b16b890c6"))
                .averageHeight(180)
                .name("Polska")
                .build();

        Nationality nationality2 = Nationality.builder()
                .id(UUID.fromString("a215d998-2c69-4965-a5bc-6715af939b2e"))
                .averageHeight(170)
                .name("Szwecja")
                .build();

        Nationality nationality3 = Nationality.builder()
                .id(UUID.fromString("dfcf0c3b-2d53-4b29-9a04-c496e0ea4d5e"))
                .averageHeight(178)
                .name("Dania")
                .build();

        Nationality nationality4 = Nationality.builder()
                .id(UUID.fromString("e126d265-75d4-4427-9059-88a209449510"))
                .averageHeight(185)
                .name("Australia")
                .build();

        nationalityService.save(nationalityMapper.nationalityToNationalityDto(nationality1));
        nationalityService.save(nationalityMapper.nationalityToNationalityDto(nationality2));
        nationalityService.save(nationalityMapper.nationalityToNationalityDto(nationality3));
        nationalityService.save(nationalityMapper.nationalityToNationalityDto(nationality4));

        //Nationality nationality
        System.out.println("Inicjalizacja danych zakonczona");
    }
}
