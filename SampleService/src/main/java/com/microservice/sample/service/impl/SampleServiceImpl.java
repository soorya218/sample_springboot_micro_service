package com.microservice.sample.service.impl;

import com.microservice.sample.entities.SampleEntity;
import com.microservice.sample.repository.SampleEntityRepository;
import com.microservice.sample.service.SampleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class SampleServiceImpl implements SampleService {
    private static final Logger LOG = LogManager.getLogger(SampleService.class);

    @Autowired
    private SampleEntityRepository sampleEntityRepository;

    @Override
    @Transactional
    public SampleEntity getSampleEntity(String uuid) {
        return (sampleEntityRepository.findOneById(UUID.fromString(uuid)));
    }
}
