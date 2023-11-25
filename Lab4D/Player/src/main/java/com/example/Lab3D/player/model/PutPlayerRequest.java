package com.example.Lab3D.player.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PutPlayerRequest {
    private String name;
    private Integer abilities;
    private UUID nationalityId;
}
