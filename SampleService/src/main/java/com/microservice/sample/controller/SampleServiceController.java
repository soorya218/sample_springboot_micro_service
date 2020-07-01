package com.microservice.sample.controller;


import com.microservice.sample.helpers.responsemodels.GenericResponse;
import com.microservice.sample.helpers.utils.SampleEntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sampleservicemgmt")
public class SampleServiceController {
    private static final Logger LOG = LogManager.getLogger(SampleServiceController.class);

    @Autowired
    SampleEntityUtils sampleEntityUtils;

    @GetMapping(value = "/check")
    public String healthCheck() {
        LOG.info("INFO: Inside healthCheck");
        LOG.debug("DEBUG: Inside healthCheck");
        LOG.error("ERROR: Inside healthCheck");
        return "Hello SampleServices!!!";
    }

    @GetMapping(path = "/{userId}/entity/{entityId}")
    public ResponseEntity<Object> getVenue(@PathVariable String userId,
                                           @PathVariable String entityId) {

        GenericResponse venue = sampleEntityUtils.getSampleEntity(userId, entityId);
        return new ResponseEntity<Object>(venue, HttpStatus.FOUND);
    }

}
