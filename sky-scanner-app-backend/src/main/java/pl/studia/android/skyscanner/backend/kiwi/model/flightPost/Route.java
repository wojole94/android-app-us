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
        "fare_basis",
        "fare_category",
        "fare_classes",
        "price",
        "fare_family",
        "found_on",
        "last_seen",
        "refresh_timestamp",
        "source",
        "return",
        "bags_recheck_required",
        "guarantee",
        "id",
        "combination_id",
        "original_return",
        "aTime",
        "dTime",
        "aTimeUTC",
        "dTimeUTC",
        "mapIdfrom",
        "mapIdto",
        "cityTo",
        "cityFrom",
        "cityCodeFrom",
        "cityCodeTo",
        "flyTo",
        "flyFrom",
        "airline",
        "operating_carrier",
        "equipment",
        "latFrom",
        "lngFrom",
        "latTo",
        "lngTo",
        "flight_no",
        "vehicle_type",
        "operating_flight_no"
})
public class Route implements Serializable {
    private final static long serialVersionUID = -5479887286685547565L;
    @JsonIgnore
    @JsonProperty("fare_basis")
    private String fareBasis;
    @JsonIgnore
    @JsonProperty("fare_category")
    private String fareCategory;
    @JsonProperty("fare_classes")
    private String fareClasses;
    @JsonIgnore
    @JsonProperty("price")
    private Integer price;
    @JsonIgnore
    @JsonProperty("fare_family")
    private String fareFamily;
    @JsonIgnore
    @JsonProperty("found_on")
    private String foundOn;
    @JsonIgnore
    @JsonProperty("last_seen")
    private Integer lastSeen;
    @JsonIgnore
    @JsonProperty("refresh_timestamp")
    private Integer refreshTimestamp;
    @JsonIgnore
    @JsonProperty("source")
    private String source;
    @JsonProperty("return")
    private Integer _return;
    @JsonIgnore
    @JsonProperty("bags_recheck_required")
    private Boolean bagsRecheckRequired;
    @JsonProperty("guarantee")
    private Boolean guarantee;
    @JsonIgnore
    @JsonProperty("id")
    private String id;
    @JsonIgnore
    @JsonProperty("combination_id")
    private String combinationId;
    @JsonIgnore
    @JsonProperty("original_return")
    private Integer originalReturn;
    @JsonProperty("aTime")
    private Integer aTime;
    @JsonProperty("dTime")
    private Integer dTime;
    @JsonProperty("aTimeUTC")
    private Integer aTimeUTC;
    @JsonProperty("dTimeUTC")
    private Integer dTimeUTC;
    @JsonIgnore
    @JsonProperty("mapIdfrom")
    private String mapIdfrom;
    @JsonIgnore
    @JsonProperty("mapIdto")
    private String mapIdto;
    @JsonProperty("cityTo")
    private String cityTo;
    @JsonProperty("cityFrom")
    private String cityFrom;
    @JsonProperty("cityCodeFrom")
    private String cityCodeFrom;
    @JsonProperty("cityCodeTo")
    private String cityCodeTo;
    @JsonProperty("flyTo")
    private String flyTo;
    @JsonProperty("flyFrom")
    private String flyFrom;
    @JsonProperty("airline")
    private String airline;
    @JsonIgnore
    @JsonProperty("operating_carrier")
    private String operatingCarrier;
    @JsonIgnore
    @JsonProperty("equipment")
    private String equipment;
    @JsonIgnore
    @JsonProperty("latFrom")
    private Double latFrom;
    @JsonIgnore
    @JsonProperty("lngFrom")
    private Double lngFrom;
    @JsonIgnore
    @JsonProperty("latTo")
    private Double latTo;
    @JsonIgnore
    @JsonProperty("lngTo")
    private Double lngTo;
    @JsonProperty("flight_no")
    private Integer flightNo;
    @JsonIgnore
    @JsonProperty("vehicle_type")
    private String vehicleType;
    @JsonProperty("operating_flight_no")
    private String operatingFlightNo;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("fare_basis")
    public String getFareBasis() {
        return fareBasis;
    }

    @JsonProperty("fare_basis")
    public void setFareBasis(String fareBasis) {
        this.fareBasis = fareBasis;
    }

    @JsonProperty("fare_category")
    public String getFareCategory() {
        return fareCategory;
    }

    @JsonProperty("fare_category")
    public void setFareCategory(String fareCategory) {
        this.fareCategory = fareCategory;
    }

    @JsonProperty("fare_classes")
    public String getFareClasses() {
        return fareClasses;
    }

    @JsonProperty("fare_classes")
    public void setFareClasses(String fareClasses) {
        this.fareClasses = fareClasses;
    }

    @JsonProperty("price")
    public Integer getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Integer price) {
        this.price = price;
    }

    @JsonProperty("fare_family")
    public String getFareFamily() {
        return fareFamily;
    }

    @JsonProperty("fare_family")
    public void setFareFamily(String fareFamily) {
        this.fareFamily = fareFamily;
    }

    @JsonProperty("found_on")
    public String getFoundOn() {
        return foundOn;
    }

    @JsonProperty("found_on")
    public void setFoundOn(String foundOn) {
        this.foundOn = foundOn;
    }

    @JsonProperty("last_seen")
    public Integer getLastSeen() {
        return lastSeen;
    }

    @JsonProperty("last_seen")
    public void setLastSeen(Integer lastSeen) {
        this.lastSeen = lastSeen;
    }

    @JsonProperty("refresh_timestamp")
    public Integer getRefreshTimestamp() {
        return refreshTimestamp;
    }

    @JsonProperty("refresh_timestamp")
    public void setRefreshTimestamp(Integer refreshTimestamp) {
        this.refreshTimestamp = refreshTimestamp;
    }

    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    @JsonProperty("return")
    public Integer getReturn() {
        return _return;
    }

    @JsonProperty("return")
    public void setReturn(Integer _return) {
        this._return = _return;
    }

    @JsonProperty("bags_recheck_required")
    public Boolean getBagsRecheckRequired() {
        return bagsRecheckRequired;
    }

    @JsonProperty("bags_recheck_required")
    public void setBagsRecheckRequired(Boolean bagsRecheckRequired) {
        this.bagsRecheckRequired = bagsRecheckRequired;
    }

    @JsonProperty("guarantee")
    public Boolean getGuarantee() {
        return guarantee;
    }

    @JsonProperty("guarantee")
    public void setGuarantee(Boolean guarantee) {
        this.guarantee = guarantee;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("combination_id")
    public String getCombinationId() {
        return combinationId;
    }

    @JsonProperty("combination_id")
    public void setCombinationId(String combinationId) {
        this.combinationId = combinationId;
    }

    @JsonProperty("original_return")
    public Integer getOriginalReturn() {
        return originalReturn;
    }

    @JsonProperty("original_return")
    public void setOriginalReturn(Integer originalReturn) {
        this.originalReturn = originalReturn;
    }

    @JsonProperty("aTime")
    public Integer getATime() {
        return aTime;
    }

    @JsonProperty("aTime")
    public void setATime(Integer aTime) {
        this.aTime = aTime;
    }

    @JsonProperty("dTime")
    public Integer getDTime() {
        return dTime;
    }

    @JsonProperty("dTime")
    public void setDTime(Integer dTime) {
        this.dTime = dTime;
    }

    @JsonProperty("aTimeUTC")
    public Integer getATimeUTC() {
        return aTimeUTC;
    }

    @JsonProperty("aTimeUTC")
    public void setATimeUTC(Integer aTimeUTC) {
        this.aTimeUTC = aTimeUTC;
    }

    @JsonProperty("dTimeUTC")
    public Integer getDTimeUTC() {
        return dTimeUTC;
    }

    @JsonProperty("dTimeUTC")
    public void setDTimeUTC(Integer dTimeUTC) {
        this.dTimeUTC = dTimeUTC;
    }

    @JsonProperty("mapIdfrom")
    public String getMapIdfrom() {
        return mapIdfrom;
    }

    @JsonProperty("mapIdfrom")
    public void setMapIdfrom(String mapIdfrom) {
        this.mapIdfrom = mapIdfrom;
    }

    @JsonProperty("mapIdto")
    public String getMapIdto() {
        return mapIdto;
    }

    @JsonProperty("mapIdto")
    public void setMapIdto(String mapIdto) {
        this.mapIdto = mapIdto;
    }

    @JsonProperty("cityTo")
    public String getCityTo() {
        return cityTo;
    }

    @JsonProperty("cityTo")
    public void setCityTo(String cityTo) {
        this.cityTo = cityTo;
    }

    @JsonProperty("cityFrom")
    public String getCityFrom() {
        return cityFrom;
    }

    @JsonProperty("cityFrom")
    public void setCityFrom(String cityFrom) {
        this.cityFrom = cityFrom;
    }

    @JsonProperty("cityCodeFrom")
    public String getCityCodeFrom() {
        return cityCodeFrom;
    }

    @JsonProperty("cityCodeFrom")
    public void setCityCodeFrom(String cityCodeFrom) {
        this.cityCodeFrom = cityCodeFrom;
    }

    @JsonProperty("cityCodeTo")
    public String getCityCodeTo() {
        return cityCodeTo;
    }

    @JsonProperty("cityCodeTo")
    public void setCityCodeTo(String cityCodeTo) {
        this.cityCodeTo = cityCodeTo;
    }

    @JsonProperty("flyTo")
    public String getFlyTo() {
        return flyTo;
    }

    @JsonProperty("flyTo")
    public void setFlyTo(String flyTo) {
        this.flyTo = flyTo;
    }

    @JsonProperty("flyFrom")
    public String getFlyFrom() {
        return flyFrom;
    }

    @JsonProperty("flyFrom")
    public void setFlyFrom(String flyFrom) {
        this.flyFrom = flyFrom;
    }

    @JsonProperty("airline")
    public String getAirline() {
        return airline;
    }

    @JsonProperty("airline")
    public void setAirline(String airline) {
        this.airline = airline;
    }

    @JsonProperty("operating_carrier")
    public String getOperatingCarrier() {
        return operatingCarrier;
    }

    @JsonProperty("operating_carrier")
    public void setOperatingCarrier(String operatingCarrier) {
        this.operatingCarrier = operatingCarrier;
    }

    @JsonProperty("equipment")
    public String getEquipment() {
        return equipment;
    }

    @JsonProperty("equipment")
    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    @JsonProperty("latFrom")
    public Double getLatFrom() {
        return latFrom;
    }

    @JsonProperty("latFrom")
    public void setLatFrom(Double latFrom) {
        this.latFrom = latFrom;
    }

    @JsonProperty("lngFrom")
    public Double getLngFrom() {
        return lngFrom;
    }

    @JsonProperty("lngFrom")
    public void setLngFrom(Double lngFrom) {
        this.lngFrom = lngFrom;
    }

    @JsonProperty("latTo")
    public Double getLatTo() {
        return latTo;
    }

    @JsonProperty("latTo")
    public void setLatTo(Double latTo) {
        this.latTo = latTo;
    }

    @JsonProperty("lngTo")
    public Double getLngTo() {
        return lngTo;
    }

    @JsonProperty("lngTo")
    public void setLngTo(Double lngTo) {
        this.lngTo = lngTo;
    }

    @JsonProperty("flight_no")
    public Integer getFlightNo() {
        return flightNo;
    }

    @JsonProperty("flight_no")
    public void setFlightNo(Integer flightNo) {
        this.flightNo = flightNo;
    }

    @JsonProperty("vehicle_type")
    public String getVehicleType() {
        return vehicleType;
    }

    @JsonProperty("vehicle_type")
    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    @JsonProperty("operating_flight_no")
    public String getOperatingFlightNo() {
        return operatingFlightNo;
    }

    @JsonProperty("operating_flight_no")
    public void setOperatingFlightNo(String operatingFlightNo) {
        this.operatingFlightNo = operatingFlightNo;
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
        return new ToStringBuilder(this).append("fareBasis", fareBasis).append("fareCategory", fareCategory).append("fareClasses", fareClasses).append("price", price).append("fareFamily", fareFamily).append("foundOn", foundOn).append("lastSeen", lastSeen).append("refreshTimestamp", refreshTimestamp).append("source", source).append("_return", _return).append("bagsRecheckRequired", bagsRecheckRequired).append("guarantee", guarantee).append("id", id).append("combinationId", combinationId).append("originalReturn", originalReturn).append("aTime", aTime).append("dTime", dTime).append("aTimeUTC", aTimeUTC).append("dTimeUTC", dTimeUTC).append("mapIdfrom", mapIdfrom).append("mapIdto", mapIdto).append("cityTo", cityTo).append("cityFrom", cityFrom).append("cityCodeFrom", cityCodeFrom).append("cityCodeTo", cityCodeTo).append("flyTo", flyTo).append("flyFrom", flyFrom).append("airline", airline).append("operatingCarrier", operatingCarrier).append("equipment", equipment).append("latFrom", latFrom).append("lngFrom", lngFrom).append("latTo", latTo).append("lngTo", lngTo).append("flightNo", flightNo).append("vehicleType", vehicleType).append("operatingFlightNo", operatingFlightNo).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(latFrom).append(fareClasses).append(foundOn).append(mapIdto).append(guarantee).append(cityFrom).append(source).append(fareCategory).append(lngFrom).append(dTimeUTC).append(aTimeUTC).append(price).append(refreshTimestamp).append(id).append(airline).append(operatingCarrier).append(flyTo).append(vehicleType).append(operatingFlightNo).append(cityCodeTo).append(latTo).append(lngTo).append(combinationId).append(equipment).append(cityTo).append(bagsRecheckRequired).append(flyFrom).append(originalReturn).append(aTime).append(_return).append(lastSeen).append(mapIdfrom).append(flightNo).append(fareBasis).append(cityCodeFrom).append(dTime).append(fareFamily).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Route) == false) {
            return false;
        }
        Route rhs = ((Route) other);
        return new EqualsBuilder().append(latFrom, rhs.latFrom).append(fareClasses, rhs.fareClasses).append(foundOn, rhs.foundOn).append(mapIdto, rhs.mapIdto).append(guarantee, rhs.guarantee).append(cityFrom, rhs.cityFrom).append(source, rhs.source).append(fareCategory, rhs.fareCategory).append(lngFrom, rhs.lngFrom).append(dTimeUTC, rhs.dTimeUTC).append(aTimeUTC, rhs.aTimeUTC).append(price, rhs.price).append(refreshTimestamp, rhs.refreshTimestamp).append(id, rhs.id).append(airline, rhs.airline).append(operatingCarrier, rhs.operatingCarrier).append(flyTo, rhs.flyTo).append(vehicleType, rhs.vehicleType).append(operatingFlightNo, rhs.operatingFlightNo).append(cityCodeTo, rhs.cityCodeTo).append(latTo, rhs.latTo).append(lngTo, rhs.lngTo).append(combinationId, rhs.combinationId).append(equipment, rhs.equipment).append(cityTo, rhs.cityTo).append(bagsRecheckRequired, rhs.bagsRecheckRequired).append(flyFrom, rhs.flyFrom).append(originalReturn, rhs.originalReturn).append(aTime, rhs.aTime).append(_return, rhs._return).append(lastSeen, rhs.lastSeen).append(mapIdfrom, rhs.mapIdfrom).append(flightNo, rhs.flightNo).append(fareBasis, rhs.fareBasis).append(cityCodeFrom, rhs.cityCodeFrom).append(dTime, rhs.dTime).append(fareFamily, rhs.fareFamily).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
