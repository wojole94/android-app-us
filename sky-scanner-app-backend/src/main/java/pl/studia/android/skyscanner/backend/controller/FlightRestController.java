package pl.studia.android.skyscanner.backend.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    DataExtractor dataExtractor;

    @PostMapping("/getBestPriceFlight")
    public SearchResult getFlights(@Valid @RequestBody SearchParameters searchParameters) throws IOException, InterruptedException {
        return dataExtractor.getBestFlightFor(searchParameters);
    }

    @GetMapping("/getProfiles")
    public List<SearchResult> getProfiles(@Valid @RequestHeader("username") String username,
                                          @Valid @RequestHeader("password") String password)
        throws IOException, InterruptedException {
        AppUser user = new AppUser(username, password);
        List<SearchResult> returnResponse = dataExtractor.getCurrentProfileStatus(user);
        return returnResponse;
    }

    @PutMapping("/updateProfiles")
    public SearchResult updateProfile(@Valid @RequestHeader("username") String username,
                                      @Valid @RequestHeader("password") String password,
                                      @Valid @RequestBody SearchParameters searchParameters)
        throws IOException, InterruptedException {
        AppUser user = new AppUser(username, password);
        SearchResult returnResponse = dataExtractor.addNewProfile(user, searchParameters);
        return returnResponse;
    }

    @DeleteMapping("/removeProfile")
    public SearchParameters removeProfiles(@Valid @RequestHeader("username") String username,
                                           @Valid @RequestHeader("password") String password,
                                           @Valid @RequestBody SearchParameters searchParameters)
        throws IOException, InterruptedException {
        return searchParameters;
    }
}
