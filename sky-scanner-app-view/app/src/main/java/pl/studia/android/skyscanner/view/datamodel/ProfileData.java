package pl.studia.android.skyscanner.view.datamodel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileData implements Serializable {

    private static final long serialVersionUID = 4014359946693362478L;
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
    @SerializedName("transfers_number")
    Integer transfersCount;
    @SerializedName("maximum_price")
    Double maxPrice;
    @SerializedName("only_weekend_flights")
    Boolean justWeekends;
    @SerializedName("deep_link")
    private String deepLink;
    @SerializedName("arrival_date")
    private String arrivalDate;
    @SerializedName("departure_date")
    private String departureDate;
    @SerializedName("price")
    private Integer price;
    @SerializedName("real_transfers_number")
    private Integer realTransfersNumber;


    public ProfileData(){
        this.adultsCount = new Integer(1);
        this.childCount = new Integer(0);
        this.departCity = "NONE";
        this.arrivalCity = "NONE";
        this.startDate = new Date();
        this.endDate = new Date();
        this.transfersCount = new Integer(0);
        this.maxPrice = new Double(1000);
        this.justWeekends = false;
        this.arrivalDate = "2019-08-01";
        this.departureDate = "2051-08-01";
        this.deepLink = "http://google.pl";
        this.price = 251;
        this.realTransfersNumber = 1;
    }

    @Override
    public String toString(){
        return "" + departCity + " > " + arrivalCity;
    }
}
