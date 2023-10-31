package com.example.Lab3D.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetNationalityResponse {
    private UUID id;
    private String name;
    private Integer averageHeight;
}