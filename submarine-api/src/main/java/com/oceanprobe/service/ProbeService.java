package com.oceanprobe.service;

import com.oceanprobe.enums.Direction;
import com.oceanprobe.model.Probe;

public class ProbeService {
    private final Probe probe;

    public ProbeService(Probe probe) {
        this.probe = probe;
        this.probe.markAsVisited();
    }

    private boolean isValidMove(int x, int y) {
        if (x < 0 || y < 0 || x > probe.getMaxX() || y > probe.getMaxY()) return false;

        // Check obstacle
        return !probe.getObstacles().contains(x + "," + y);
    }

    public void moveForward() {
        int nextX = probe.getX();
        int nextY = probe.getY();

        switch (probe.getDirection()) {
            case NORTH:
                nextY++;
                break;
            case EAST:
                nextX++;
                break;
            case SOUTH:
                nextY--;
                break;
            case WEST:
                nextX--;
        }
//        probe.markAsVisited();
        if (isValidMove(nextX, nextY)) {
            probe.setX(nextX);
            probe.setY(nextY);
            probe.markAsVisited();
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

    public void moveBackward() {
        int nextX = probe.getX();
        int nextY = probe.getY();
        switch (probe.getDirection()) {
            case NORTH:
                nextY--;
                break;
            case EAST:
                nextX--;
                break;
            case SOUTH:
                nextY++;
                break;
            case WEST:
                nextX++;
        }
//        probe.markAsVisited();
        if (isValidMove(nextX, nextY)) {
            probe.setX(nextX);
            probe.setY(nextY);
            probe.markAsVisited();
        }
    }

    public void processCommands(String commands) {
        for (char command : commands.toCharArray()) {
//            System.out.println("Executing command: " + command);
            switch (command) {
                case 'F' -> moveForward();
                case 'B' -> moveBackward();
                case 'L' -> turnLeft();
                case 'R' -> turnRight();
                default -> throw new IllegalArgumentException("Invalid command: " + command);
            }
//            System.out.println("Current position: (" + probe.getX() + "," + probe.getY() + ") facing " + probe.getDirection());
        }
    }

}
