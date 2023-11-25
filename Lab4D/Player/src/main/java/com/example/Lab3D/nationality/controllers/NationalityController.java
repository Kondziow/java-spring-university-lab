package com.example.Lab3D.nationality.controllers;

import com.example.Lab3D.nationality.entities.Nationality;
import com.example.Lab3D.nationality.mappers.NationalityMapper;
import com.example.Lab3D.nationality.model.NationalityDTO;
import com.example.Lab3D.nationality.services.NationalityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class NationalityController {
    public static final String NATIONALITY_PATH = "/api/nationalities";
    public static final String NATIONALITY_PATH_ID = NATIONALITY_PATH + "/{nationalityId}";

    private final NationalityService nationalityService;
    private final NationalityMapper nationalityMapper;

    @DeleteMapping(NATIONALITY_PATH_ID)
    public ResponseEntity<Void> deleteNationality(@PathVariable("nationalityId") UUID uuid) {
        nationalityService.delete(uuid);
        return ResponseEntity.accepted().build();
    }

    @PutMapping(NATIONALITY_PATH_ID)
    public ResponseEntity<Void> putNationality(@PathVariable("nationalityId")UUID uuid, @RequestBody NationalityDTO nationalityDTO) {
        //Nationality nationality = Nationality.builder().id(uuid).build();
        nationalityDTO.setId(uuid);
        nationalityService.save(nationalityMapper.nationalityDtoToNationality(nationalityDTO));
        return ResponseEntity.accepted().build();
    }
}
