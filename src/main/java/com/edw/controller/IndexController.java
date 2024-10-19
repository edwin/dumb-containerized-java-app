package com.edw.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 *  com.edw.controller.IndexController
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 19 Oct 2024 10:43
 */
@RestController
public class IndexController {

    @Value("${health.probe.seconds}")
    private Integer healthProbeSecond;

    @Value("${ready.probe.seconds}")
    private Integer readyProbeSeconds;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping(path = "/")
    public ResponseEntity index() throws Exception {
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/health")
    public ResponseEntity health() throws Exception {

        logger.debug("delaying liveness response for {} s", healthProbeSecond);

        Thread.sleep(healthProbeSecond * 1000);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/ready")
    public ResponseEntity ready() throws Exception {

        logger.debug("delaying readiness response for {} s", readyProbeSeconds);

        Thread.sleep(readyProbeSeconds * 1000);
        return ResponseEntity.ok().build();
    }
}