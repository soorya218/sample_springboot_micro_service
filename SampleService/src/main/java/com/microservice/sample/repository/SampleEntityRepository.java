package com.microservice.sample.repository;

import com.microservice.sample.entities.SampleEntity;
import org.hibernate.type.UUIDBinaryType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SampleEntityRepository extends JpaRepository<SampleEntity, UUIDBinaryType> {
    SampleEntity findOneById(UUID id);
}
