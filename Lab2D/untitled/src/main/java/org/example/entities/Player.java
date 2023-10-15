package org.example.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.Comparator;
import java.util.UUID;

@Entity(name = "players")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "players")
public class Player implements Comparable<Player>{
    @Id
    private UUID id;

    private String name;
    private int abilities;

    @ManyToOne //(fetch = FetchType.EAGER)
    @JoinColumn(name = "nationality_id")
    @ToString.Exclude
    private Nationality nationality;


    @Override
    public int compareTo(Player o) {
        return Comparator.comparing(Player::getAbilities)
                .thenComparing(Player::getName)
                .compare(this, o);
    }
}
