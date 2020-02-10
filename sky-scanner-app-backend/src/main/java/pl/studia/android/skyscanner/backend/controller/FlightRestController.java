package pl.studia.android.skyscanner.backend.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.studia.android.skyscanner.backend.kiwi.model.Flights;
import pl.studia.android.skyscanner.backend.kiwi.model.PostAttr;
import pl.studia.android.skyscanner.backend.kiwi.model.PostQuery;
import pl.studia.android.skyscanner.backend.kiwi.model.flightPost.SearchDetail;
import pl.studia.android.skyscanner.backend.model.SearchParameters;
import pl.studia.android.skyscanner.backend.model.SearchResult;

import javax.validation.Valid;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightRestController {

    /**
     * This method search the cheapest flight over a period of time.
     *
     * @param searchParameters
     * @return null when requirements not meet or one SearchResult with best price.
     * @throws IOException
     * @throws InterruptedException
     */
    @PostMapping("/getBestPriceFlight")
    public SearchResult getFlights(@Valid @RequestBody SearchParameters searchParameters) throws IOException, InterruptedException {
        SearchResult returnResponse = null;
        LocalDate date = LocalDate.now();
        PostAttr postAttr = new PostAttr(
                searchParameters.getCityFrom(),
                searchParameters.getCityTo(),
                searchParameters.getSearchStartDate(),
                searchParameters.getSearchEndDate(),
                null,
                searchParameters.getAdultsNumber() + searchParameters.getChildrenNumber(),
                searchParameters.getAdultsNumber(),
                searchParameters.getChildrenNumber(),
                searchParameters.getMaximumPrice()
        );
        PostQuery postQuery = new PostQuery();
        postQuery.addToPostQuery(postAttr);
        ObjectMapper objectMapper = new ObjectMapper();

        //correct date json format
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        String requestBody = objectMapper.writeValueAsString(postQuery);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.skypicker.com/flights_multi?partner=picky&locale=pl&curr=PLN"))
                .POST(HttpRequest.BodyPublishers.ofString(requestBody)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

//        SearchDetail[][] searchDetails = objectMapper.readValue(response.body(), SearchDetail[][].class);
        List<SearchDetail[]> searchDetailsList = objectMapper.readValue(response.body(), new TypeReference<List<SearchDetail[]>>() {
        });
        for (SearchDetail[] searchDetailArray : searchDetailsList) {
            if (searchDetailArray != null && searchDetailArray.length > 0) {
                Flights flights = new Flights(searchDetailArray);//TODO - narazie zawsze odczytuje jedno połączenie
                SearchDetail flightWithBestPrice = flights.getFlightWithBestPrice();
                SearchResult searchResult = new SearchResult();
                searchResult.setCityFrom(flightWithBestPrice.getCityFrom());
                searchResult.setCityTo(flightWithBestPrice.getCityTo());
                searchResult.setPrice(flightWithBestPrice.getPrice());
                searchResult.setDepartureDate(LocalDateTime.ofInstant(flightWithBestPrice.getDTimeUTC(), ZoneOffset.UTC));
                searchResult.setArrivalDate(LocalDateTime.ofInstant(flightWithBestPrice.getATimeUTC(), ZoneOffset.UTC));
                returnResponse = searchResult;
//            String responseJson = objectMapper.writeValueAsString(searchResult);
//            System.out.println(searchResult.toString());
            }
        }
        return returnResponse;
    }
}
