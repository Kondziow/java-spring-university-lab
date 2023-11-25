package com.example.Lab3D.nationality.model;

import com.example.Lab3D.nationality.model.dto.NationalityDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetNationalitiesResponse {
    private List<NationalityDTO> nationalities;
}
