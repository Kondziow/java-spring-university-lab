package org.example.services;

import org.example.entities.Nationality;
import org.example.entities.Player;

import java.util.List;

public interface NationalityService {
    Nationality save(Nationality nationality);
    List<Nationality> findAll();
}
