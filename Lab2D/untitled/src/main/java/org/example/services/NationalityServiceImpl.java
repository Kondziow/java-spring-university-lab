package org.example.services;

import org.example.entities.Nationality;
import org.example.entities.Player;
import org.example.repositories.NationalityRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Primary
@Service
public class NationalityServiceImpl implements NationalityService {

    private final NationalityRepository nationalityRepository;

    public NationalityServiceImpl(NationalityRepository nationalityRepository) {
        this.nationalityRepository = nationalityRepository;
    }

    @Override
    public Nationality save(Nationality nationality) {
        return nationalityRepository.save(nationality);
    }

    @Override
    public List<Nationality> findAll() {
        return nationalityRepository.findAll();
    }
}
