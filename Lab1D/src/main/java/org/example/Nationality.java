package org.example;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Data
@Builder
public class Nationality implements Comparable<Nationality>, Serializable {
    private String name;
    private int averageHeight;
    @Builder.Default
    List<Player> playerList = new ArrayList<>();

    @Override
    public int compareTo(Nationality o) {
        return Comparator.comparing(Nationality::getName)
                .thenComparing(Nationality::getAverageHeight)
                .compare(this, o);
    }

    @Override
    public String toString() {
        String returnValue = "Nationality{" +
                "name='" + name + '\'' +
                ", averageHeight=" + averageHeight +"}";
        return returnValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nationality that = (Nationality) o;
        return averageHeight == that.averageHeight && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, averageHeight);
    }
}
