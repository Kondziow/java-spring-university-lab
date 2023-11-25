package com.example.Lab3D.nationality.services;

import com.example.Lab3D.nationality.model.dto.NationalityDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NationalityService {
    NationalityDTO save(NationalityDTO nationality);
    List<NationalityDTO> findAll();
    Optional<NationalityDTO> findById(UUID id);
    void updateById(UUID id, NationalityDTO nationality);
    Boolean deleteById(UUID id);
}
