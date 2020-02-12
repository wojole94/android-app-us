package pl.studia.android.skyscanner.backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class SearchResult {
    @JsonProperty("city_from")
    private String cityFrom;
    @JsonProperty("city_to")
    private String cityTo;
    @JsonProperty("price")
    private Integer price;
    @JsonProperty("departure_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime departureDate;
    @JsonProperty("arrival_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime arrivalDate;
}
