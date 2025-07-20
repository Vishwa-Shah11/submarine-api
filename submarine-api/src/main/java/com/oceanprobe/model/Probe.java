package com.oceanprobe.model;

import com.oceanprobe.enums.Direction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Probe {
    private int x;
    private int y;
    private Direction direction;

    private int maxX;
    private int maxY;

    public Probe(int x, int y, Direction direction, int maxX, int maxY) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    private Set<String> visited = new LinkedHashSet<>();

    public void markAsVisited() {
        visited.add("("+ x + "," + y + ")");
    }
}
