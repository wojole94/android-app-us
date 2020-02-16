package pl.studia.android.skyscanner.backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class SearchResult {
    @JsonProperty("id")
    Integer id;
    @JsonProperty("fly_from")
    private String flyFrom;
    @JsonProperty("fly_to")
    private String flyTo;
    @JsonProperty("date_from")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime dateFrom;
    @JsonProperty("date_to")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime dateTo;
    @JsonProperty("adults")
    private Integer adults;
    @JsonProperty("children")
    private Integer children;
    @JsonProperty("price_to")
    private Integer maximumPrice;
    @JsonProperty("only_weekends")
    private Boolean onlyWeekends;
    @JsonProperty("transfers_count")
    private Integer transfersCount;
    @JsonProperty("price")
    private Double currentPrice;
    @JsonProperty("departure_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime exactDepartureDate;
    @JsonProperty("arrival_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime exactArrivalDate;
    @JsonProperty("deep_link")
    String deepLink;
    @JsonProperty("real_transfers_number")
    private Integer realTransfersNumber;

}
