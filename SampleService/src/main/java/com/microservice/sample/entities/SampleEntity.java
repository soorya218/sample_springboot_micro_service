
package com.microservice.sample.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

@Entity
public class SampleEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", nullable = false, columnDefinition = "BINARY(16)")
    @org.hibernate.annotations.Type(type="org.hibernate.type.UUIDBinaryType")
    private UUID id;

    @Basic
    @Column(name = "name", nullable = false, length = 32)
    private String name;

    @Basic
    @Column(name = "description", nullable = true, length = 255)
    private String description;

    @Basic
    @Column(name = "createdon", nullable = false)
    private Timestamp createdon;

    @Basic
    @Column(name = "createdby", nullable = false, length = 32)
    private String createdby;

    @Basic
    @Column(name = "updatedon", nullable = true)
    private Timestamp updatedon;

    @Basic
    @Column(name = "updatedby", nullable = true, length = 32)
    private String updatedby;

    @Basic
    @Column(name = "deletedon", nullable = true)
    private Timestamp deletedon;

    @Basic
    @Column(name = "deletedby", nullable = true, length = 32)
    private String deletedby;

    @Basic
    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreatedon() {
        return createdon;
    }

    public void setCreatedon(Timestamp createdon) {
        this.createdon = createdon;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public Timestamp getUpdatedon() {
        return updatedon;
    }

    public void setUpdatedon(Timestamp updatedon) {
        this.updatedon = updatedon;
    }

    public String getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(String updatedby) {
        this.updatedby = updatedby;
    }

    public Timestamp getDeletedon() {
        return deletedon;
    }

    public void setDeletedon(Timestamp deletedon) {
        this.deletedon = deletedon;
    }

    public String getDeletedby() {
        return deletedby;
    }

    public void setDeletedby(String deletedby) {
        this.deletedby = deletedby;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @PrePersist
    public void prePersist() {

        createdon = new Timestamp(System.currentTimeMillis());
        createdby = "Anand";

    }

    @PreUpdate
    public void preUpdate() {
        updatedon = new Timestamp(System.currentTimeMillis());
        updatedby = "Anand";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SampleEntity sampleEntity = (SampleEntity) o;
        return  isDeleted == sampleEntity.isDeleted &&
                Objects.equals(id, sampleEntity.getId()) &&
                Objects.equals(name, sampleEntity.name) &&
                Objects.equals(description, sampleEntity.description) &&
                Objects.equals(createdon, sampleEntity.createdon) &&
                Objects.equals(createdby, sampleEntity.createdby) &&
                Objects.equals(updatedon, sampleEntity.updatedon) &&
                Objects.equals(updatedby, sampleEntity.updatedby) &&
                Objects.equals(deletedon, sampleEntity.deletedon) &&
                Objects.equals(deletedby, sampleEntity.deletedby);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, description, createdon, createdby, updatedon, updatedby, deletedon, deletedby, isDeleted);
        result = 31 * result + Objects.hashCode(id);
        return result;
    }

    public SampleEntity() {
    }

    public SampleEntity(String name, String description, String tagCategory) {
        this.name = name;
        this.description = description;
    }
}
