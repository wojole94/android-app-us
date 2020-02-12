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
        "1"
})
public class BagsPrice implements Serializable {

    private final static long serialVersionUID = -5558227257623906809L;
    @JsonProperty("1")
    private Double _1;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("1")
    public Double get1() {
        return _1;
    }

    @JsonProperty("1")
    public void set1(Double _1) {
        this._1 = _1;
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
        return new ToStringBuilder(this).append("_1", _1).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(_1).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BagsPrice) == false) {
            return false;
        }
        BagsPrice rhs = ((BagsPrice) other);
        return new EqualsBuilder().append(_1, rhs._1).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
