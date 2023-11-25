package com.example.Lab3D.nationality.controllers;

import com.example.Lab3D.nationality.mappers.NationalityMapper;
import com.example.Lab3D.nationality.model.GetNationalitiesResponse;
import com.example.Lab3D.nationality.model.GetNationalityResponse;
import com.example.Lab3D.nationality.model.dto.NationalityDTO;
import com.example.Lab3D.nationality.services.NationalityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class NationalityController {
    public static final String NATIONALITY_PATH = "/api/nationalities";
    public static final String NATIONALITY_PATH_ID = NATIONALITY_PATH + "/{nationalityId}";
    private final NationalityMapper nationalityMapper;
    private final NationalityService nationalityService;

    @PutMapping(NATIONALITY_PATH_ID)
    public ResponseEntity<Void> updateNationalityById(@PathVariable("nationalityId") UUID id, @RequestBody NationalityDTO nationality) {
        nationalityService.updateById(id, nationality);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(NATIONALITY_PATH_ID)
    public ResponseEntity<Void> deleteNationalityById(@PathVariable("nationalityId") UUID id) {
        nationalityService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(NATIONALITY_PATH)
    public ResponseEntity<GetNationalitiesResponse> getAllNationalities() {
        return ResponseEntity.ok(GetNationalitiesResponse.builder()
                .nationalities(nationalityService.findAll())
                .build());
    }

    @GetMapping(NATIONALITY_PATH_ID)
    public ResponseEntity<GetNationalityResponse> getNationalityById(@PathVariable("nationalityId") UUID id) {
        return ResponseEntity.ok(nationalityService.findById(id)
                .map(nationalityMapper::nationalityDtoToGetNationalityResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }
}
