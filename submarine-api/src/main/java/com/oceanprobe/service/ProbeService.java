package com.oceanprobe.service;

import com.oceanprobe.enums.Direction;
import com.oceanprobe.model.Probe;

public class ProbeService {
    private final Probe probe;

    public ProbeService(Probe probe) {
        this.probe = probe;
    }

    public void moveForward() {
        int x = probe.getX();
        int y = probe.getY();

        switch (probe.getDirection()) {
            case NORTH:
                probe.setY(y + 1);
                break;
            case EAST:
                probe.setX(x + 1);
                break;
            case SOUTH:
                probe.setY(y - 1);
                break;
            case WEST:
                probe.setX(x - 1);
        }
    }

    public void turnLeft() {
        Direction current = probe.getDirection();
        Direction newDirection;

        switch (current) {
            case NORTH:
                newDirection = Direction.WEST;
                break;
            case EAST:
                newDirection = Direction.NORTH;
                break;
            case SOUTH:
                newDirection = Direction.EAST;
                break;
            case WEST:
                newDirection = Direction.SOUTH;
            default:
                throw new IllegalStateException("Unexpected value: " + current);
        }
        probe.setDirection(newDirection);
    }

    public void turnRight() {
        Direction current = probe.getDirection();
        Direction newDirection;

        switch (current) {
            case NORTH:
                newDirection = Direction.EAST;
                break;
            case EAST:
                newDirection = Direction.SOUTH;
                break;
            case SOUTH:
                newDirection = Direction.WEST;
                break;
            case WEST:
                newDirection = Direction.NORTH;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + current);
        }
        probe.setDirection(newDirection);
    }
}
