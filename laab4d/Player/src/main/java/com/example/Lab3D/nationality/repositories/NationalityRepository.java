package com.example.Lab3D.nationality.repositories;

import com.example.Lab3D.nationality.entities.Nationality;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NationalityRepository extends JpaRepository<Nationality, UUID> {
}
