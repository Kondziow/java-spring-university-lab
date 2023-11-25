package com.example.Lab3D.player.model;

import com.example.Lab3D.nationality.model.NationalityDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetPlayerResponse {
    private UUID id;
    private String name;
    private Integer abilities;
    //private NationalityDTO nationality;
}
