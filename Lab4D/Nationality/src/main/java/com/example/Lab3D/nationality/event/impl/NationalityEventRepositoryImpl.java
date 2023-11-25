package com.example.Lab3D.nationality.event.impl;

import com.example.Lab3D.nationality.controllers.NationalityController;
import com.example.Lab3D.nationality.entities.Nationality;
import com.example.Lab3D.nationality.event.api.NationalityEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class NationalityEventRepositoryImpl implements NationalityEventRepository {
    private final RestTemplate restTemplate;

    /*@Autowired
    public NationalityEventRepositoryImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }*/

    @Override
    public void delete(UUID uuid) {
        restTemplate.delete("/api/nationalities/{nationalityId}", uuid);
    }

    @Override
    public void create(UUID uuid, Nationality nationality) {
        Nationality nationality1 = Nationality.builder().build();
        restTemplate.put("/api/nationalities/{nationalityId}", nationality1, uuid);
    }
}
