package pl.studia.android.skyscanner.backend.kiwi.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.studia.android.skyscanner.backend.kiwi.model.flightPost.SearchDetail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Flights {
    private List<SearchDetail> flightList;

    public Flights(List<SearchDetail> flightList) {
        if (flightList != null)
            this.flightList = flightList;
        else
            this.flightList = new ArrayList<>();
    }

    public Flights(SearchDetail[] flightList) {
        this.flightList = Arrays.stream(flightList).collect(Collectors.toCollection(ArrayList::new));
        if (flightList == null)
            this.flightList = new ArrayList<>();
    }

    public SearchDetail getFlightWithBestPrice() {
        SearchDetail bestPriceFlight = null;
        for (SearchDetail flight : flightList) {
            if (bestPriceFlight == null)
                bestPriceFlight = flight;
            else {
                if (flight.getPrice() > bestPriceFlight.getPrice()) { //TODO teraz zwraca tylko jeden najlepszy - co jeżeli dwa w tej samej cenie
                    bestPriceFlight = flight;
                }
            }
        }
        return bestPriceFlight;
    }
}
