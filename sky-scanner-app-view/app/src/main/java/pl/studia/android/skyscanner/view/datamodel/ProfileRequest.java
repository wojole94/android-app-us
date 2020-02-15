
package pl.studia.android.skyscanner.view.datamodel;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuppressWarnings("unused")
public class ProfileRequest {

    @SerializedName("adults_number")
    private Integer adultsNumber;
    @SerializedName("children_number")
    private Integer childrenNumber;
    @SerializedName("city_from")
    private String cityFrom;
    @SerializedName("city_to")
    private String cityTo;
    @SerializedName("maximum_price")
    private Double maximumPrice;
    @SerializedName("only_weekend_flights")
    private Boolean onlyWeekendFlights;
    @SerializedName("search_end_date")
    private String searchEndDate;
    @SerializedName("search_start_date")
    private String searchStartDate;
    @SerializedName("transfers_number")
    private Integer transfersNumber;

}
