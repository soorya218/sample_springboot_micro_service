package com.microservice.sample.helpers.utils;

import com.microservice.sample.entities.SampleEntity;
import com.microservice.sample.helpers.responsemodels.SampleResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class SampleResponseUtils {


    public SampleResponse convertToSampleResponse(SampleEntity sampleEntity) {
        SampleResponse sampleResponse = new SampleResponse();
        BeanUtils.copyProperties(sampleEntity, sampleResponse);

        return sampleResponse;
    }
}
