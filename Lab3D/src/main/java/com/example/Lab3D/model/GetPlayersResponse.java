package com.example.Lab3D.model;

import com.example.Lab3D.model.dto.PlayerDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetPlayersResponse {
    private List<PlayerDTO> players;
}
