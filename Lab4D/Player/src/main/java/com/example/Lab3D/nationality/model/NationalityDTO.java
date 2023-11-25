package com.example.Lab3D.nationality.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NationalityDTO {
    private UUID id;
    private String name;
    private Integer averageHeight;
    private List<UUID> players;
}