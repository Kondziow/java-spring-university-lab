package com.example.Lab3D.nationality.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

@Entity(name = "nationalities")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "nationalities")
public class Nationality implements Comparable<Nationality> {
    @Id
    private UUID id;

    private String name;

    @Column(name = "average_height")
    private int averageHeight;

    @Override
    public int compareTo(Nationality o) {
        return Comparator.comparing(Nationality::getName)
                .thenComparing(Nationality::getAverageHeight)
                .compare(this, o);
    }
}