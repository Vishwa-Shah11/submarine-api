package com.oceanprobe.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class ProbeResponse {
    private int finalX;
    private int finalY;
    private String finalDirection;
    private Set<String> visitedCoordinates;
}
