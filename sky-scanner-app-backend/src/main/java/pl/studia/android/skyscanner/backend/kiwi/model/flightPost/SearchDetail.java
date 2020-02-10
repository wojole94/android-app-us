package pl.studia.android.skyscanner.backend.kiwi.model.flightPost;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "route",
        "dTime",
        "dTimeUTC",
        "aTime",
        "aTimeUTC",
        "nightsInDest",
        "duration",
        "fly_duration",
        "flyFrom",
        "cityFrom",
        "cityCodeFrom",
        "countryFrom",
        "mapIdfrom",
        "flyTo",
        "cityTo",
        "cityCodeTo",
        "countryTo",
        "mapIdto",
        "distance",
        "routes",
        "airlines",
        "pnr_count",
        "virtual_interlining",
        "has_airport_change",
        "technical_stops",
        "price",
        "bags_price",
        "baglimit",
        "availability",
        "facilitated_booking_available",
        "p1",
        "p2",
        "p3",
        "transfers",
        "type_flights",
        "found_on",
        "conversion",
        "quality",
        "booking_token",
        "deep_link"
})
public class SearchDetail implements Serializable {
    private final static long serialVersionUID = -7652916337612379734L;
    @JsonIgnore
    @JsonProperty("id")
    private String id;
    @JsonProperty("route")
    private List<Route> route = null;
    @JsonProperty("dTime")
    private Instant dTime;
    @JsonProperty("dTimeUTC")
    private Instant dTimeUTC;
    @JsonProperty("aTime")
    private Instant aTime;
    @JsonProperty("aTimeUTC")
    private Instant aTimeUTC;
    @JsonIgnore
    @JsonProperty("nightsInDest")
    private Object nightsInDest;
    @JsonIgnore
    @JsonProperty("duration")
    private Duration duration;
    @JsonProperty("fly_duration")
    private String flyDuration;
    @JsonProperty("flyFrom")
    private String flyFrom;
    @JsonProperty("cityFrom")
    private String cityFrom;
    @JsonIgnore
    @JsonProperty("cityCodeFrom")
    private String cityCodeFrom;
    @JsonProperty("countryFrom")
    private CountryFrom countryFrom;
    @JsonIgnore
    @JsonProperty("mapIdfrom")
    private String mapIdfrom;
    @JsonProperty("flyTo")
    private String flyTo;
    @JsonProperty("cityTo")
    private String cityTo;
    @JsonIgnore
    @JsonProperty("cityCodeTo")
    private String cityCodeTo;
    @JsonProperty("countryTo")
    private CountryTo countryTo;
    @JsonIgnore
    @JsonProperty("mapIdto")
    private String mapIdto;
    @JsonProperty("distance")
    private Double distance;
    @JsonProperty("routes")
    private List<List<String>> routes = null;
    @JsonProperty("airlines")
    private List<String> airlines = null;
    @JsonProperty("pnr_count")
    private Integer pnrCount;
    @JsonIgnore
    @JsonProperty("virtual_interlining")
    private Boolean virtualInterlining;
    @JsonProperty("has_airport_change")
    private Boolean hasAirportChange;
    @JsonIgnore
    @JsonProperty("technical_stops")
    private Integer technicalStops;
    @JsonProperty("price")
    private Integer price;
    @JsonProperty("bags_price")
    private BagsPrice bagsPrice;
    @JsonIgnore
    @JsonProperty("baglimit")
    private Baglimit baglimit;
    @JsonIgnore
    @JsonProperty("availability")
    private Availability availability;
    @JsonIgnore
    @JsonProperty("facilitated_booking_available")
    private Boolean facilitatedBookingAvailable;
    @JsonIgnore
    @JsonProperty("p1")
    private Integer p1;
    @JsonIgnore
    @JsonProperty("p2")
    private Integer p2;
    @JsonIgnore
    @JsonProperty("p3")
    private Integer p3;
    @JsonIgnore
    @JsonProperty("transfers")
    private List<Object> transfers = null;
    @JsonIgnore
    @JsonProperty("type_flights")
    private List<String> typeFlights = null;
    @JsonIgnore
    @JsonProperty("found_on")
    private List<String> foundOn = null;
    @JsonIgnore
    @JsonProperty("conversion")
    private Conversion conversion;
    @JsonIgnore
    @JsonProperty("quality")
    private Double quality;
    @JsonIgnore
    @JsonProperty("booking_token")
    private String bookingToken;
    @JsonProperty("deep_link")
    private String deepLink;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("route")
    public List<Route> getRoute() {
        return route;
    }

    @JsonProperty("route")
    public void setRoute(List<Route> route) {
        this.route = route;
    }

    @JsonProperty("dTime")
    public Instant getDTime() {
        return dTime;
    }

    @JsonProperty("dTime")
    public void setDTime(Instant dTime) {
        this.dTime = dTime;
    }

    @JsonProperty("dTimeUTC")
    public Instant getDTimeUTC() {
        return dTimeUTC;
    }

    @JsonProperty("dTimeUTC")
    public void setDTimeUTC(Instant dTimeUTC) {
        this.dTimeUTC = dTimeUTC;
    }

    @JsonProperty("aTime")
    public Instant getATime() {
        return aTime;
    }

    @JsonProperty("aTime")
    public void setATime(Instant aTime) {
        this.aTime = aTime;
    }

    @JsonProperty("aTimeUTC")
    public Instant getATimeUTC() {
        return aTimeUTC;
    }

    @JsonProperty("aTimeUTC")
    public void setATimeUTC(Instant aTimeUTC) {
        this.aTimeUTC = aTimeUTC;
    }

    @JsonProperty("nightsInDest")
    public Object getNightsInDest() {
        return nightsInDest;
    }

    @JsonProperty("nightsInDest")
    public void setNightsInDest(Object nightsInDest) {
        this.nightsInDest = nightsInDest;
    }

    @JsonProperty("duration")
    public Duration getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    @JsonProperty("fly_duration")
    public String getFlyDuration() {
        return flyDuration;
    }

    @JsonProperty("fly_duration")
    public void setFlyDuration(String flyDuration) {
        this.flyDuration = flyDuration;
    }

    @JsonProperty("flyFrom")
    public String getFlyFrom() {
        return flyFrom;
    }

    @JsonProperty("flyFrom")
    public void setFlyFrom(String flyFrom) {
        this.flyFrom = flyFrom;
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

    @JsonProperty("countryFrom")
    public CountryFrom getCountryFrom() {
        return countryFrom;
    }

    @JsonProperty("countryFrom")
    public void setCountryFrom(CountryFrom countryFrom) {
        this.countryFrom = countryFrom;
    }

    @JsonProperty("mapIdfrom")
    public String getMapIdfrom() {
        return mapIdfrom;
    }

    @JsonProperty("mapIdfrom")
    public void setMapIdfrom(String mapIdfrom) {
        this.mapIdfrom = mapIdfrom;
    }

    @JsonProperty("flyTo")
    public String getFlyTo() {
        return flyTo;
    }

    @JsonProperty("flyTo")
    public void setFlyTo(String flyTo) {
        this.flyTo = flyTo;
    }

    @JsonProperty("cityTo")
    public String getCityTo() {
        return cityTo;
    }

    @JsonProperty("cityTo")
    public void setCityTo(String cityTo) {
        this.cityTo = cityTo;
    }

    @JsonProperty("cityCodeTo")
    public String getCityCodeTo() {
        return cityCodeTo;
    }

    @JsonProperty("cityCodeTo")
    public void setCityCodeTo(String cityCodeTo) {
        this.cityCodeTo = cityCodeTo;
    }

    @JsonProperty("countryTo")
    public CountryTo getCountryTo() {
        return countryTo;
    }

    @JsonProperty("countryTo")
    public void setCountryTo(CountryTo countryTo) {
        this.countryTo = countryTo;
    }

    @JsonProperty("mapIdto")
    public String getMapIdto() {
        return mapIdto;
    }

    @JsonProperty("mapIdto")
    public void setMapIdto(String mapIdto) {
        this.mapIdto = mapIdto;
    }

    @JsonProperty("distance")
    public Double getDistance() {
        return distance;
    }

    @JsonProperty("distance")
    public void setDistance(Double distance) {
        this.distance = distance;
    }

    @JsonProperty("routes")
    public List<List<String>> getRoutes() {
        return routes;
    }

    @JsonProperty("routes")
    public void setRoutes(List<List<String>> routes) {
        this.routes = routes;
    }

    @JsonProperty("airlines")
    public List<String> getAirlines() {
        return airlines;
    }

    @JsonProperty("airlines")
    public void setAirlines(List<String> airlines) {
        this.airlines = airlines;
    }

    @JsonProperty("pnr_count")
    public Integer getPnrCount() {
        return pnrCount;
    }

    @JsonProperty("pnr_count")
    public void setPnrCount(Integer pnrCount) {
        this.pnrCount = pnrCount;
    }

    @JsonProperty("virtual_interlining")
    public Boolean getVirtualInterlining() {
        return virtualInterlining;
    }

    @JsonProperty("virtual_interlining")
    public void setVirtualInterlining(Boolean virtualInterlining) {
        this.virtualInterlining = virtualInterlining;
    }

    @JsonProperty("has_airport_change")
    public Boolean getHasAirportChange() {
        return hasAirportChange;
    }

    @JsonProperty("has_airport_change")
    public void setHasAirportChange(Boolean hasAirportChange) {
        this.hasAirportChange = hasAirportChange;
    }

    @JsonProperty("technical_stops")
    public Integer getTechnicalStops() {
        return technicalStops;
    }

    @JsonProperty("technical_stops")
    public void setTechnicalStops(Integer technicalStops) {
        this.technicalStops = technicalStops;
    }

    @JsonProperty("price")
    public Integer getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Integer price) {
        this.price = price;
    }

    @JsonProperty("bags_price")
    public BagsPrice getBagsPrice() {
        return bagsPrice;
    }

    @JsonProperty("bags_price")
    public void setBagsPrice(BagsPrice bagsPrice) {
        this.bagsPrice = bagsPrice;
    }

    @JsonProperty("baglimit")
    public Baglimit getBaglimit() {
        return baglimit;
    }

    @JsonProperty("baglimit")
    public void setBaglimit(Baglimit baglimit) {
        this.baglimit = baglimit;
    }

    @JsonProperty("availability")
    public Availability getAvailability() {
        return availability;
    }

    @JsonProperty("availability")
    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    @JsonProperty("facilitated_booking_available")
    public Boolean getFacilitatedBookingAvailable() {
        return facilitatedBookingAvailable;
    }

    @JsonProperty("facilitated_booking_available")
    public void setFacilitatedBookingAvailable(Boolean facilitatedBookingAvailable) {
        this.facilitatedBookingAvailable = facilitatedBookingAvailable;
    }

    @JsonProperty("p1")
    public Integer getP1() {
        return p1;
    }

    @JsonProperty("p1")
    public void setP1(Integer p1) {
        this.p1 = p1;
    }

    @JsonProperty("p2")
    public Integer getP2() {
        return p2;
    }

    @JsonProperty("p2")
    public void setP2(Integer p2) {
        this.p2 = p2;
    }

    @JsonProperty("p3")
    public Integer getP3() {
        return p3;
    }

    @JsonProperty("p3")
    public void setP3(Integer p3) {
        this.p3 = p3;
    }

    @JsonProperty("transfers")
    public List<Object> getTransfers() {
        return transfers;
    }

    @JsonProperty("transfers")
    public void setTransfers(List<Object> transfers) {
        this.transfers = transfers;
    }

    @JsonProperty("type_flights")
    public List<String> getTypeFlights() {
        return typeFlights;
    }

    @JsonProperty("type_flights")
    public void setTypeFlights(List<String> typeFlights) {
        this.typeFlights = typeFlights;
    }

    @JsonProperty("found_on")
    public List<String> getFoundOn() {
        return foundOn;
    }

    @JsonProperty("found_on")
    public void setFoundOn(List<String> foundOn) {
        this.foundOn = foundOn;
    }

    @JsonProperty("conversion")
    public Conversion getConversion() {
        return conversion;
    }

    @JsonProperty("conversion")
    public void setConversion(Conversion conversion) {
        this.conversion = conversion;
    }

    @JsonProperty("quality")
    public Double getQuality() {
        return quality;
    }

    @JsonProperty("quality")
    public void setQuality(Double quality) {
        this.quality = quality;
    }

    @JsonProperty("booking_token")
    public String getBookingToken() {
        return bookingToken;
    }

    @JsonProperty("booking_token")
    public void setBookingToken(String bookingToken) {
        this.bookingToken = bookingToken;
    }

    @JsonProperty("deep_link")
    public String getDeepLink() {
        return deepLink;
    }

    @JsonProperty("deep_link")
    public void setDeepLink(String deepLink) {
        this.deepLink = deepLink;
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
        return new ToStringBuilder(this).append("id", id).append("route", route).append("dTime", dTime).append("dTimeUTC", dTimeUTC).append("aTime", aTime).append("aTimeUTC", aTimeUTC).append("nightsInDest", nightsInDest).append("duration", duration).append("flyDuration", flyDuration).append("flyFrom", flyFrom).append("cityFrom", cityFrom).append("cityCodeFrom", cityCodeFrom).append("countryFrom", countryFrom).append("mapIdfrom", mapIdfrom).append("flyTo", flyTo).append("cityTo", cityTo).append("cityCodeTo", cityCodeTo).append("countryTo", countryTo).append("mapIdto", mapIdto).append("distance", distance).append("routes", routes).append("airlines", airlines).append("pnrCount", pnrCount).append("virtualInterlining", virtualInterlining).append("hasAirportChange", hasAirportChange).append("technicalStops", technicalStops).append("price", price).append("bagsPrice", bagsPrice).append("baglimit", baglimit).append("availability", availability).append("facilitatedBookingAvailable", facilitatedBookingAvailable).append("p1", p1).append("p2", p2).append("p3", p3).append("transfers", transfers).append("typeFlights", typeFlights).append("foundOn", foundOn).append("conversion", conversion).append("quality", quality).append("bookingToken", bookingToken).append("deepLink", deepLink).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(p1).append(p2).append(hasAirportChange).append(p3).append(distance).append(technicalStops).append(mapIdto).append(foundOn).append(cityFrom).append(availability).append(dTimeUTC).append(aTimeUTC).append(duration).append(routes).append(nightsInDest).append(price).append(transfers).append(countryFrom).append(airlines).append(id).append(bookingToken).append(flyTo).append(bagsPrice).append(conversion).append(cityCodeTo).append(baglimit).append(pnrCount).append(virtualInterlining).append(cityTo).append(flyFrom).append(countryTo).append(quality).append(aTime).append(facilitatedBookingAvailable).append(route).append(mapIdfrom).append(deepLink).append(flyDuration).append(cityCodeFrom).append(dTime).append(additionalProperties).append(typeFlights).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SearchDetail) == false) {
            return false;
        }
        SearchDetail rhs = ((SearchDetail) other);
        return new EqualsBuilder().append(p1, rhs.p1).append(p2, rhs.p2).append(hasAirportChange, rhs.hasAirportChange).append(p3, rhs.p3).append(distance, rhs.distance).append(technicalStops, rhs.technicalStops).append(mapIdto, rhs.mapIdto).append(foundOn, rhs.foundOn).append(cityFrom, rhs.cityFrom).append(availability, rhs.availability).append(dTimeUTC, rhs.dTimeUTC).append(aTimeUTC, rhs.aTimeUTC).append(duration, rhs.duration).append(routes, rhs.routes).append(nightsInDest, rhs.nightsInDest).append(price, rhs.price).append(transfers, rhs.transfers).append(countryFrom, rhs.countryFrom).append(airlines, rhs.airlines).append(id, rhs.id).append(bookingToken, rhs.bookingToken).append(flyTo, rhs.flyTo).append(bagsPrice, rhs.bagsPrice).append(conversion, rhs.conversion).append(cityCodeTo, rhs.cityCodeTo).append(baglimit, rhs.baglimit).append(pnrCount, rhs.pnrCount).append(virtualInterlining, rhs.virtualInterlining).append(cityTo, rhs.cityTo).append(flyFrom, rhs.flyFrom).append(countryTo, rhs.countryTo).append(quality, rhs.quality).append(aTime, rhs.aTime).append(facilitatedBookingAvailable, rhs.facilitatedBookingAvailable).append(route, rhs.route).append(mapIdfrom, rhs.mapIdfrom).append(deepLink, rhs.deepLink).append(flyDuration, rhs.flyDuration).append(cityCodeFrom, rhs.cityCodeFrom).append(dTime, rhs.dTime).append(additionalProperties, rhs.additionalProperties).append(typeFlights, rhs.typeFlights).isEquals();
    }

}
