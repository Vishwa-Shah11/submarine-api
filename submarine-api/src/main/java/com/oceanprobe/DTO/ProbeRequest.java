package com.oceanprobe.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ProbeRequest {
    private int x;
    private int y;
    private String direction;
    private int maxX;
    private int maxY;
    private List<String> obstacles;
    private String commands;
}
