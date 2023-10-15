package org.example.repositories;

import org.example.entities.Nationality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NationalityRepository extends JpaRepository<Nationality, UUID> {
}
