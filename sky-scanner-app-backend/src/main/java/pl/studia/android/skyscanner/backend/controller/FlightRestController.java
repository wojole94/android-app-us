package pl.studia.android.skyscanner.backend.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.*;

import pl.studia.android.skyscanner.backend.connector.KiwiConnection;
import pl.studia.android.skyscanner.backend.kiwi.model.flightPost.SearchDetail;
import pl.studia.android.skyscanner.backend.mapping.DataExtractor;
import pl.studia.android.skyscanner.backend.mapping.SearchParametersDTOMapper;
import pl.studia.android.skyscanner.backend.model.AppUser;
import pl.studia.android.skyscanner.backend.model.SearchParameters;
import pl.studia.android.skyscanner.backend.model.SearchResult;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

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
        DataExtractor dataExtractor = new DataExtractor();
        return dataExtractor.getBestFlightFor(searchParameters);
    }

    @PostMapping("/getProfiles")
    public List<SearchResult> getProfiles(@Valid @RequestBody AppUser appUser) throws IOException,
        InterruptedException {
        DataExtractor dataExtractor = new DataExtractor();
        List<SearchResult> returnResponse = dataExtractor.getCurrentProfileStatus(appUser);
        return returnResponse;
    }

    @PutMapping("/updateProfiles")
    public SearchResult updateProfile(@Valid @RequestBody SearchParameters searchParameters) throws IOException,
        InterruptedException {
        DataExtractor dataExtractor = new DataExtractor();
       // List<SearchResult> returnResponse = dataExtractor.addNewProfile(appUser);
        return null;
    }

    @DeleteMapping("/removeProfile")
    public SearchParameters removeProfiles(@Valid @RequestBody SearchParameters searchParameters) throws IOException,
        InterruptedException {
        return searchParameters;
    }
}
