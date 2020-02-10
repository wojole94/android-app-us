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
        "hand_width",
        "hand_height",
        "hand_length",
        "hand_weight",
        "hold_width",
        "hold_height",
        "hold_length",
        "hold_dimensions_sum",
        "hold_weight"
})
public class Baglimit implements Serializable {

    private final static long serialVersionUID = 139796781813445351L;
    @JsonProperty("hand_width")
    private Integer handWidth;
    @JsonProperty("hand_height")
    private Integer handHeight;
    @JsonProperty("hand_length")
    private Integer handLength;
    @JsonProperty("hand_weight")
    private Integer handWeight;
    @JsonProperty("hold_width")
    private Integer holdWidth;
    @JsonProperty("hold_height")
    private Integer holdHeight;
    @JsonProperty("hold_length")
    private Integer holdLength;
    @JsonProperty("hold_dimensions_sum")
    private Integer holdDimensionsSum;
    @JsonProperty("hold_weight")
    private Integer holdWeight;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("hand_width")
    public Integer getHandWidth() {
        return handWidth;
    }

    @JsonProperty("hand_width")
    public void setHandWidth(Integer handWidth) {
        this.handWidth = handWidth;
    }

    @JsonProperty("hand_height")
    public Integer getHandHeight() {
        return handHeight;
    }

    @JsonProperty("hand_height")
    public void setHandHeight(Integer handHeight) {
        this.handHeight = handHeight;
    }

    @JsonProperty("hand_length")
    public Integer getHandLength() {
        return handLength;
    }

    @JsonProperty("hand_length")
    public void setHandLength(Integer handLength) {
        this.handLength = handLength;
    }

    @JsonProperty("hand_weight")
    public Integer getHandWeight() {
        return handWeight;
    }

    @JsonProperty("hand_weight")
    public void setHandWeight(Integer handWeight) {
        this.handWeight = handWeight;
    }

    @JsonProperty("hold_width")
    public Integer getHoldWidth() {
        return holdWidth;
    }

    @JsonProperty("hold_width")
    public void setHoldWidth(Integer holdWidth) {
        this.holdWidth = holdWidth;
    }

    @JsonProperty("hold_height")
    public Integer getHoldHeight() {
        return holdHeight;
    }

    @JsonProperty("hold_height")
    public void setHoldHeight(Integer holdHeight) {
        this.holdHeight = holdHeight;
    }

    @JsonProperty("hold_length")
    public Integer getHoldLength() {
        return holdLength;
    }

    @JsonProperty("hold_length")
    public void setHoldLength(Integer holdLength) {
        this.holdLength = holdLength;
    }

    @JsonProperty("hold_dimensions_sum")
    public Integer getHoldDimensionsSum() {
        return holdDimensionsSum;
    }

    @JsonProperty("hold_dimensions_sum")
    public void setHoldDimensionsSum(Integer holdDimensionsSum) {
        this.holdDimensionsSum = holdDimensionsSum;
    }

    @JsonProperty("hold_weight")
    public Integer getHoldWeight() {
        return holdWeight;
    }

    @JsonProperty("hold_weight")
    public void setHoldWeight(Integer holdWeight) {
        this.holdWeight = holdWeight;
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
        return new ToStringBuilder(this).append("handWidth", handWidth).append("handHeight", handHeight).append("handLength", handLength).append("handWeight", handWeight).append("holdWidth", holdWidth).append("holdHeight", holdHeight).append("holdLength", holdLength).append("holdDimensionsSum", holdDimensionsSum).append("holdWeight", holdWeight).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(holdWeight).append(handLength).append(holdLength).append(handHeight).append(holdWidth).append(handWidth).append(holdHeight).append(holdDimensionsSum).append(additionalProperties).append(handWeight).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Baglimit) == false) {
            return false;
        }
        Baglimit rhs = ((Baglimit) other);
        return new EqualsBuilder().append(holdWeight, rhs.holdWeight).append(handLength, rhs.handLength).append(holdLength, rhs.holdLength).append(handHeight, rhs.handHeight).append(holdWidth, rhs.holdWidth).append(handWidth, rhs.handWidth).append(holdHeight, rhs.holdHeight).append(holdDimensionsSum, rhs.holdDimensionsSum).append(additionalProperties, rhs.additionalProperties).append(handWeight, rhs.handWeight).isEquals();
    }

}
