package com.oceanprobe.model;

import com.oceanprobe.enums.Direction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Probe {
    private int x;
    private int y;
    private Direction direction;
}
