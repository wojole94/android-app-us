
package pl.studia.android.skyscanner.view.datamodel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuppressWarnings("unused")
public class ProfileResponse implements Serializable {

    private static final long serialVersionUID = 3019468091516452892L;
    private Integer adults;
    @SerializedName("arrival_date")
    private String arrivalDate;
    private Integer children;
    @SerializedName("date_from")
    private String dateFrom;
    @SerializedName("date_to")
    private String dateTo;
    @SerializedName("deep_link")
    private String deepLink;
    @SerializedName("departure_date")
    private String departureDate;
    @SerializedName("fly_from")
    private String flyFrom;
    @SerializedName("fly_to")
    private String flyTo;
    private Integer id;
    @SerializedName("only_weekends")
    private Boolean onlyWeekends;
    private Integer price;
    @SerializedName("price_to")
    private Integer priceTo;
    @SerializedName("transfers_count")
    private Integer transfersCount;

}
