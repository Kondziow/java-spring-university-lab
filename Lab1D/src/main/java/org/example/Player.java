package org.example;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.nio.charset.CoderMalfunctionError;
import java.util.Comparator;

@Data
@Builder
public class Player implements Comparable<Player>, Serializable {
    private String name;
    private int abilities;
    private Nationality nationality;


    @Override
    public int compareTo(Player o) {
        return Comparator.comparing(Player::getAbilities)
                .thenComparing(Player::getAbilities)
                .compare(this, o);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", abilities=" + abilities +
                ", nationality=" + nationality.getName() +
                '}';
    }
}
