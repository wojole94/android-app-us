package pl.studia.android.skyscanner.backend.kiwi.model.flightPost;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonIgnoreType
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "seats"
})
public class Availability implements Serializable {

    private final static long serialVersionUID = -2893699307001552052L;
    @JsonProperty("seats")
    private Integer seats;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("seats")
    public Integer getSeats() {
        return seats;
    }

    @JsonProperty("seats")
    public void setSeats(Integer seats) {
        this.seats = seats;
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
        return new ToStringBuilder(this).append("seats", seats).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(seats).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Availability) == false) {
            return false;
        }
        Availability rhs = ((Availability) other);
        return new EqualsBuilder().append(seats, rhs.seats).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
