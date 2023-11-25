package com.example.Lab3D.nationality.services;

import com.example.Lab3D.nationality.entities.Nationality;
import com.example.Lab3D.nationality.repositories.NationalityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.internal.CustomizerRegistry;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NationalityService {
    private final NationalityRepository nationalityRepository;

    public void save(Nationality nationality) {
        nationalityRepository.save(nationality);
    }

    public void delete(UUID uuid) {
        nationalityRepository.deleteById(uuid);
    }
}
