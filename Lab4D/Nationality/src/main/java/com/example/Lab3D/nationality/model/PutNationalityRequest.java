package com.example.Lab3D.nationality.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PutNationalityRequest {
    private String name;
    private int averageHeight;
}
