package com.oceanprobe.service;

import com.oceanprobe.enums.Direction;
import com.oceanprobe.model.Probe;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class ProbeServiceTest {

    @Test
    void testMoveForwardWhenFacingNorth() {
        Probe probe = new Probe(0, 0, Direction.NORTH, 5, 5);
        ProbeService probeService = new ProbeService(probe);

        probeService.moveForward();

        assertEquals(0, probe.getX());
        assertEquals(1, probe.getY());
        assertEquals(Direction.NORTH, probe.getDirection());
    }

    @Test
    void testTurnLeftFromNorth() {
        Probe probe = new Probe(0, 0, Direction.NORTH, 5, 5);
        ProbeService probeService = new ProbeService(probe);

        probeService.turnLeft();

        assertEquals(Direction.WEST, probe.getDirection());
    }

    @Test
    void turnRightFromNorth() {
        Probe probe = new Probe(0, 0, Direction.NORTH, 5, 5);
        ProbeService probeService = new ProbeService(probe);

        probeService.turnRight();

        assertEquals(Direction.EAST, probe.getDirection());
    }

    @Test
    void testMoveBackwardsWhenFacingNorth() {
        Probe probe = new Probe(0, 1, Direction.NORTH, 5, 5);
        ProbeService probeService = new ProbeService(probe);

        probeService.moveBackward();

        assertEquals(0, probe.getX());
        assertEquals(0, probe.getY());
    }

    @Test
    void testMoveForwardBlockedByGridBoundry() {
        Probe probe = new Probe(0, 5, Direction.NORTH, 5, 5);
        ProbeService probeService = new ProbeService(probe);

        probeService.moveForward();

        assertEquals(0, probe.getX());
        assertEquals(5, probe.getY());
        assertEquals(Direction.NORTH, probe.getDirection());
    }

    @Test
    void testVisitedCoordinatesAfterMoves() {
        Probe probe = new Probe(0, 0, Direction.NORTH, 5, 5);
        ProbeService probeService = new ProbeService(probe);

        probeService.moveForward();  // (0,1)
        probeService.turnRight();    // EAST
        probeService.moveForward();  // (1,1)

        Set<String> visited = probe.getVisited();

        assertTrue(visited.contains("(0,0)"));
        assertTrue(visited.contains("(0,1)"));
        assertTrue(visited.contains("(1,1)"));
        assertEquals(3, visited.size());
    }

    @Test
    void testAvoidObstacle() {
        Probe probe = new Probe(0, 0, Direction.NORTH, 5, 5);
        probe.addObstacle(0, 1);  // Obstacle directly in front

        ProbeService probeService = new ProbeService(probe);

        probeService.moveForward();  // Should not move
        probeService.moveBackward();
        assertEquals(0, probe.getX());
        assertEquals(0, probe.getY());
    }

    @Test
    void testProcessCommands() {
        Probe probe = new Probe(0, 0, Direction.NORTH, 5, 5);
        ProbeService probeService = new ProbeService(probe);
        probeService.processCommands("FFRFF");

        assertEquals(2, probe.getX());
        assertEquals(2, probe.getY());
        assertEquals(Direction.EAST, probe.getDirection());
        assertTrue(probe.getVisited().contains("(0,0)"));
        assertTrue(probe.getVisited().contains("(0,1)"));
        assertTrue(probe.getVisited().contains("(0,2)"));
        assertTrue(probe.getVisited().contains("(1,2)"));
        assertTrue(probe.getVisited().contains("(2,2)"));
    }


}
