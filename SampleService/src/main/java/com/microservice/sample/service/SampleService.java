package com.microservice.sample.service;

import com.microservice.sample.entities.SampleEntity;

public interface SampleService {
    SampleEntity getSampleEntity(String uuid);
}
