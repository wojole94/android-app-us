package pl.studia.android.skyscanner.view.datamodel;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileData implements Serializable {

    private static final long serialVersionUID = -828333982958927658L;

    Integer adultsCount;
    Integer childCount;
    String departCity;
    String arrivalCity;
    Date startDate;
    Date endDate;
    Integer transfersCount;
    Double maxPrice;
    Boolean justWeekends;

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
