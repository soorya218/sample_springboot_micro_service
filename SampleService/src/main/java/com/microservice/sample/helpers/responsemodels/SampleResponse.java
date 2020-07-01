package com.microservice.sample.helpers.responsemodels;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.*;

@Data

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "description"
})
public class SampleResponse implements Serializable
{

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 3322765116383240281L;

    /**
     * No args constructor for use in serialization
     *
     */
    public SampleResponse() {
    }

    /**
     *
     * @param description
     * @param name
     */
    public SampleResponse(String id, String name, String description) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @JsonProperty("id")
    public String get_Id() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public void setId(UUID id) {
        this.id = id.toString();
    }

    public UUID getId() {
        return UUID.fromString(id);
    }


    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("name", name).append("description", description)
                .append("additionalProperties", additionalProperties)
                .toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(additionalProperties).append(description).append(name).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SampleResponse) == false) {
            return false;
        }
        SampleResponse rhs = ((SampleResponse) other);
        return new EqualsBuilder()
                .append(additionalProperties, rhs.additionalProperties).append(description, rhs.description).append(name, rhs.name).isEquals();
    }

}