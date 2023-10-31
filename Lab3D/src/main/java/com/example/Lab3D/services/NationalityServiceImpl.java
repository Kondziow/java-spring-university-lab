package com.example.Lab3D.services;

import com.example.Lab3D.entities.Player;
import com.example.Lab3D.mappers.NationalityMapper;
import com.example.Lab3D.model.dto.NationalityDTO;
import com.example.Lab3D.repositories.NationalityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NationalityServiceImpl implements NationalityService {
    private final NationalityRepository nationalityRepository;
    private final NationalityMapper nationalityMapper;

    @Override
    public NationalityDTO save(NationalityDTO nationality) {
        return nationalityMapper.nationalityToNationalityDto(nationalityRepository.save(nationalityMapper.nationalityDtoToNationality(nationality)));
    }

    @Override
    public List<NationalityDTO> findAll() {
        return nationalityRepository.findAll().stream()
                .map(nationalityMapper::nationalityToNationalityDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<NationalityDTO> findById(UUID id) {
        return Optional.ofNullable(nationalityMapper.nationalityToNationalityDto(nationalityRepository.findById(id)
                .orElse(null)));
    }

    @Override
    public void updateById(UUID id, NationalityDTO nationality) {
       nationality.setId(id);
       nationalityRepository.save(nationalityMapper.nationalityDtoToNationality(nationality));
    }

    @Override
    public Boolean deleteById(UUID id) {
        if(nationalityRepository.existsById(id)) {
            nationalityRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
