package com.microservice.sample.helpers.utils;

import com.microservice.sample.entities.SampleEntity;
import com.microservice.sample.exceptions.ResourceNotFoundException;
import com.microservice.sample.exceptions.UserNotFoundException;
import com.microservice.sample.helpers.constants.MessageConstants;
import com.microservice.sample.helpers.responsemodels.GenericResponse;
import com.microservice.sample.helpers.responsemodels.SampleResponse;
import com.microservice.sample.service.SampleService;
import com.microservice.sample.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
public class SampleEntityUtils {
    private static final Logger LOG = LogManager.getLogger(SampleEntityUtils.class);

    @Autowired
    private SampleService sampleService;

    @Autowired
    private UserService userService;

    @Autowired
    SampleResponseUtils sampleResponseUtils;


    private boolean validateUser(String userId) {
        if (!userService.validateUser(userId))
            throw new UserNotFoundException(userId);

        return true;
    }

    public GenericResponse getSampleEntity(String userId, String entityId) {

        LOG.debug("Getting Venue details.");
        validateUser(userId);

        SampleEntity sampleEntity = getSampleEntity(entityId);
        if (isNull(sampleEntity))
            throw new ResourceNotFoundException(MessageConstants.RESOURCE_NOT_FOUND);

        SampleResponse sampleResponse = sampleResponseUtils.convertToSampleResponse(sampleEntity);
        return (new GenericResponse(sampleResponse, MessageConstants.ENTITY_FOUND));
    }

    public SampleEntity getSampleEntity(String entityId) {
        return (sampleService.getSampleEntity(entityId));

    }
}
