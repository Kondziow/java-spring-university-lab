package org.example;

import lombok.Data;

import java.io.Serializable;

@Data
public class PlayerDto{
    private String name;
    private int abilities;
    private String nationality;

    public PlayerDto(String name, int abilities, String nationality) {
        this.name = name;
        this.abilities = abilities;
        this.nationality = nationality;
    }
}
