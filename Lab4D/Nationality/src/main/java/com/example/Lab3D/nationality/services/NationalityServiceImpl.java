package com.example.Lab3D.nationality.services;

import com.example.Lab3D.nationality.event.api.NationalityEventRepository;
import com.example.Lab3D.nationality.mappers.NationalityMapper;
import com.example.Lab3D.nationality.model.dto.NationalityDTO;
import com.example.Lab3D.nationality.repositories.NationalityRepository;
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
    private final NationalityEventRepository nationalityEventRepository;

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
       nationalityEventRepository.create(id, null);
    }

    @Override
    public Boolean deleteById(UUID id) {
        if(nationalityRepository.existsById(id)) {
            nationalityEventRepository.delete(id);
            nationalityRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
