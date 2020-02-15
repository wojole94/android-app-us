package pl.studia.android.skyscanner.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pl.studia.android.skyscanner.backend.mapping.DataExtractor;
import pl.studia.android.skyscanner.backend.model.AppUser;
import pl.studia.android.skyscanner.backend.model.SearchParameters;
import pl.studia.android.skyscanner.backend.model.SearchResult;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/getProfile")
    public Optional<SearchResult> getProfile(@RequestParam("id") Integer id,
                                              @Valid @RequestParam("email") String username,
                                              @Valid @RequestParam("password") String password)
            throws IOException, InterruptedException {
        AppUser user = new AppUser(username, password);
        Optional<SearchResult> returnResponse = dataExtractor.getCurrentProfileQueryStatus(id, user);
        return returnResponse;
    }

    @GetMapping("/getProfiles")
    public List<SearchResult> getProfiles(@Valid @RequestParam("username") String username,
                                          @Valid @RequestParam("password") String password)
        throws IOException, InterruptedException {
        AppUser user = new AppUser(username, password);
        List<SearchResult> returnResponse = dataExtractor.getCurrentProfileStatus(user);
        return returnResponse;
    }

    @PutMapping("/updateProfiles")
    public SearchResult updateProfile(@Valid @RequestParam("email") String email,
                                      @Valid @RequestParam("password") String password,
                                      @Valid @RequestBody SearchParameters searchParameters)
        throws IOException, InterruptedException {
        AppUser user = new AppUser(email, password);
        SearchResult returnResponse = dataExtractor.upsertProfile(user, searchParameters);
        return returnResponse;
    }

    @DeleteMapping("/removeProfile")
    public Boolean removeProfiles(@Valid @RequestParam("username") String username,
                                           @Valid @RequestParam("password") String password,
                                           @Valid @RequestBody SearchResult searchResult)
        throws IOException, InterruptedException {

        AppUser user = new AppUser(username, password);
//        SearchResult returnResponse = dataExtractor.removeProfile(user, searchResult);
        dataExtractor.removeProfile(user, searchResult);
        return true;
    }
}
