package pl.studia.android.skyscanner.view.datamodel;

import android.text.Html;
import android.text.Spanned;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import static android.text.Html.fromHtml;

@Getter
@Setter
@Data
public class ProfileData implements Serializable {


    private static final long serialVersionUID = 69988321935349113L;
    Integer id;
    @SerializedName("adults_number")
    Integer adultsCount;
    @SerializedName("children_number")
    Integer childCount;
    @SerializedName("city_from")
    String departCity;
    @SerializedName("city_to")
    String arrivalCity;
    @SerializedName("search_start_date")
    Date startDate;
    @SerializedName("search_end_date")
    Date endDate;
    @SerializedName("max_stopovers")
    Integer maxStopovers;
    @SerializedName("maximum_price")
    Double maxPrice;
    @SerializedName("deep_link")
    private String deepLink;
    @SerializedName("arrival_date")
    private Date arrivalDate;
    @SerializedName("departure_date")
    private Date departureDate;
    @SerializedName("price")
    private Double price;
    @SerializedName("real_transfers_number")
    private Integer realTransfersNumber;

    public ProfileData() {
        this.adultsCount = Integer.valueOf(1);
        this.childCount = Integer.valueOf(0);
        this.departCity = "NONE";
        this.arrivalCity = "NONE";
        this.startDate = new Date();
        this.endDate = new Date();
        this.maxStopovers = Integer.valueOf(2);
        this.maxPrice = Double.valueOf(1000);
    }
//
//    @Override
//    public String toString() {
//        return "" + departCity + " > " + arrivalCity;
//    }

    public Spanned getFlightRoute(){
//        if(departCity!=null && arrivalCity!= null)
        return fromHtml(departCity+"<br/>---v---<br/>"+arrivalCity);
    }
}
