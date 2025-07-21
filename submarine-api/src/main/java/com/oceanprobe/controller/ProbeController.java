package com.oceanprobe.controller;

import com.oceanprobe.DTO.ProbeRequest;
import com.oceanprobe.DTO.ProbeResponse;
import com.oceanprobe.enums.Direction;
import com.oceanprobe.model.Probe;
import com.oceanprobe.service.ProbeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;

@RestController
@RequestMapping("/api/probe")
public class ProbeController {

//    @Autowired
//    ProbeService probeService;

    @PostMapping("/navigate")
    public ProbeResponse navigate(@RequestBody ProbeRequest request) {
        Probe probe = new Probe(
                request.getX(),
                request.getY(),
                Direction.valueOf(request.getDirection().toUpperCase()),
                request.getMaxX(),
                request.getMaxY()
        );
        probe.setObstacles(new HashSet<>(request.getObstacles()));

        ProbeService probeService = new ProbeService(probe);
        probeService.processCommands(request.getCommands());

        return new ProbeResponse(
                probe.getX(),
                probe.getY(),
                probe.getDirection().name(),
                probe.getVisited()
        );
    }
}
