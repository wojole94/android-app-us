package pl.studia.android.skyscanner.view.datamodel;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileData {
    Integer adultsCount;
    Integer childCount;
    String departCity;
    String arrivalCity;
    Date startDate;
    Date endDate;
    Integer transfersCount;
    Double maxPrice;
    Boolean justWeekends;

    @Override
    public String toString(){
        return "" + departCity + " > " + arrivalCity;
    }
}
