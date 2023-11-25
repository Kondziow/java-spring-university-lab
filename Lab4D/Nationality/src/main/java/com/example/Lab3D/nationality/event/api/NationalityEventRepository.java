package com.example.Lab3D.nationality.event.api;

import com.example.Lab3D.nationality.entities.Nationality;

import java.util.UUID;

public interface NationalityEventRepository {
    void delete(UUID uuid);
    void create(UUID uuid, Nationality nationality);
}
