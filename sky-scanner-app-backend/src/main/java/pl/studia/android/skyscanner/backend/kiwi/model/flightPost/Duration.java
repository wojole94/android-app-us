package pl.studia.android.skyscanner.backend.kiwi.model.flightPost;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "departure",
        "return",
        "total"
})
public class Duration implements Serializable {

    private final static long serialVersionUID = -2427686025082371789L;
    @JsonProperty("departure")
    private Integer departure;
    @JsonProperty("return")
    private Integer _return;
    @JsonProperty("total")
    private Integer total;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("departure")
    public Integer getDeparture() {
        return departure;
    }

    @JsonProperty("departure")
    public void setDeparture(Integer departure) {
        this.departure = departure;
    }

    @JsonProperty("return")
    public Integer getReturn() {
        return _return;
    }

    @JsonProperty("return")
    public void setReturn(Integer _return) {
        this._return = _return;
    }

    @JsonProperty("total")
    public Integer getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(Integer total) {
        this.total = total;
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
        return new ToStringBuilder(this).append("departure", departure).append("_return", _return).append("total", total).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(_return).append(total).append(departure).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Duration) == false) {
            return false;
        }
        Duration rhs = ((Duration) other);
        return new EqualsBuilder().append(_return, rhs._return).append(total, rhs.total).append(departure, rhs.departure).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
