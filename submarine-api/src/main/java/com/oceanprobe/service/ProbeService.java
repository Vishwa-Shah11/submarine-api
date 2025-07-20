package com.oceanprobe.service;

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
}
