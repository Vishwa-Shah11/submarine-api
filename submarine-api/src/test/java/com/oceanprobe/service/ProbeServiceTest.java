package com.oceanprobe.service;

import com.oceanprobe.enums.Direction;
import com.oceanprobe.model.Probe;

import static org.junit.jupiter.api.Assertions.*;

public class ProbeServiceTest {

    void testMoveForwardWhenFacingNorth() {
        Probe probe = new Probe(0, 0, Direction.NORTH);
        ProbeService probeService = new ProbeService(probe);

        probeService.moveFarward();

        assertEquals(0, probe.getX());
        assertEquals(1, probe.getY());
        assertEquals(Direction.NORTH, probe.getDirection());
    }
}
