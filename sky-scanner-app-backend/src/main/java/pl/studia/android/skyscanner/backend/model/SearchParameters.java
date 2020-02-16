package pl.studia.android.skyscanner.backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SearchParameters {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("city_from")
    private String cityFrom;
    @JsonProperty("city_to")
    private String cityTo;
    @JsonProperty("search_start_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime searchStartDate;
    @JsonProperty("search_end_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime searchEndDate;
    //    @JsonProperty("length_of_stay")
//    private Integer lengthOfStay;
    @JsonProperty("transfers_number")
    private Integer transfersNumber;
    @JsonProperty("adults_number")
    private Integer adultsNumber;
    @JsonProperty("children_number")
    private Integer childrenNumber;
    @JsonProperty("maximum_price")
    private Integer maximumPrice;
    @JsonProperty("only_weekend_flights")
    private Boolean onlyWeekendFlights;
    @JsonProperty("price")
    Double currentPrice;
    @JsonProperty("departure_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    LocalDateTime exactDepartureDate;
    @JsonProperty("arrival_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    LocalDateTime exactArrivalDate;
    @JsonProperty("deep_link")
    String deepLink;
    @JsonProperty("real_transfers_number")
    Integer realTransfersNumber;

    public SearchParameters() {
    }

}
