package com.example.Lab3D.nationality.entities;

import com.example.Lab3D.player.entities.Player;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(name = "nationalities")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "nationalities")
public class Nationality {
    @Id
    private UUID id;

    @Builder.Default
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "nationality", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Player> playerList = new ArrayList<>();

}