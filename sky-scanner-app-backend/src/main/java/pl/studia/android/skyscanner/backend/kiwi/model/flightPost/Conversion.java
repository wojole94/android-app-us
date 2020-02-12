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
        "PLN",
        "EUR"
})
public class Conversion implements Serializable {

    private final static long serialVersionUID = 5523980043437654431L;
    @JsonProperty("PLN")
    private Integer pLN;
    @JsonProperty("EUR")
    private Integer eUR;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("PLN")
    public Integer getPLN() {
        return pLN;
    }

    @JsonProperty("PLN")
    public void setPLN(Integer pLN) {
        this.pLN = pLN;
    }

    @JsonProperty("EUR")
    public Integer getEUR() {
        return eUR;
    }

    @JsonProperty("EUR")
    public void setEUR(Integer eUR) {
        this.eUR = eUR;
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
        return new ToStringBuilder(this).append("pLN", pLN).append("eUR", eUR).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(pLN).append(eUR).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Conversion) == false) {
            return false;
        }
        Conversion rhs = ((Conversion) other);
        return new EqualsBuilder().append(pLN, rhs.pLN).append(eUR, rhs.eUR).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
