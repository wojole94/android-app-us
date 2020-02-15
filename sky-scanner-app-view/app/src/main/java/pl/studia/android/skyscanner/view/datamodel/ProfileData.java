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

    private static final long serialVersionUID = -828333982958927658L;

    Integer id;
    Integer adultsCount;
    Integer childCount;
    String departCity;
    String arrivalCity;
    Date startDate;
    Date endDate;
    Integer transfersCount;
    Double maxPrice;
    Boolean justWeekends;

    @SerializedName("adults")
    private Long mAdults;
    @SerializedName("arrival_date")
    private String mArrivalDate;
    @SerializedName("children")
    private Long mChildren;
    @SerializedName("date_from")
    private String mDateFrom;
    @SerializedName("date_to")
    private String mDateTo;
    @SerializedName("deep_link")
    private String mDeepLink;
    @SerializedName("departure_date")
    private String mDepartureDate;
    @SerializedName("fly_from")
    private String mFlyFrom;
    @SerializedName("fly_to")
    private String mFlyTo;
    @SerializedName("id")
    private Object mId;
    @SerializedName("only_weekends")
    private Boolean mOnlyWeekends;
    @SerializedName("price")
    private Long mPrice;
    @SerializedName("price_to")
    private Long mPriceTo;
    @SerializedName("transfers_count")
    private Long mTransfersCount;



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
    }

    @Override
    public String toString(){
        return "" + departCity + " > " + arrivalCity;
    }
}
