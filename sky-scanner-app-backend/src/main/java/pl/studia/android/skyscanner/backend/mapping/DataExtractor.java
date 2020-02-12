package pl.studia.android.skyscanner.backend.mapping;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.studia.android.skyscanner.backend.connector.KiwiConnection;
import pl.studia.android.skyscanner.backend.db.manager.SearchParametersManager;
import pl.studia.android.skyscanner.backend.db.manager.UserAccountManager;
import pl.studia.android.skyscanner.backend.db.model.SearchParametersDTO;
import pl.studia.android.skyscanner.backend.db.model.UserAccountDTO;
import pl.studia.android.skyscanner.backend.db.repository.SearchParametersRepository;
import pl.studia.android.skyscanner.backend.kiwi.model.Flights;
import pl.studia.android.skyscanner.backend.kiwi.model.flightPost.SearchDetail;
import pl.studia.android.skyscanner.backend.model.AppUser;
import pl.studia.android.skyscanner.backend.model.SearchParameters;
import pl.studia.android.skyscanner.backend.model.SearchResult;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
@AllArgsConstructor
public class DataExtractor {

    @Autowired
    SearchParametersRepository profilesRepository;

    @Autowired
    SearchParametersManager profilesManager;

    @Autowired
    UserAccountManager userManager;



    public SearchResult getBestFlightFor(SearchParameters searchParameters) throws IOException, InterruptedException {
        SearchResult returnResponse = null;
        KiwiConnection connection = new KiwiConnection();
        SearchParametersDTOMapper mapper = Mappers.getMapper(SearchParametersDTOMapper.class);
        List<SearchDetail[]> searchDetailsList =
            connection.performSearchRequest(mapper.mapToSearchParametersDTO(searchParameters));
        return getBestFlight(searchDetailsList);
    }

    private SearchResult getBestFlight(List<SearchDetail[]> listOfResults) {
        for (SearchDetail[] searchDetailArray : listOfResults) {
            if (searchDetailArray != null && searchDetailArray.length > 0) {
                Flights flights = new Flights(searchDetailArray);//TODO - narazie zawsze odczytuje jedno połączenie
                SearchDetail flightWithBestPrice = flights.getFlightWithBestPrice();
                SearchResult searchResult = new SearchResult();
                searchResult.setFlyFrom(flightWithBestPrice.getCityFrom());
                searchResult.setFlyTo(flightWithBestPrice.getCityTo());
                searchResult.setCurrentPrice(flightWithBestPrice.getPrice());
                searchResult.setExactDepartureDate(LocalDateTime.ofInstant(flightWithBestPrice.getDTimeUTC(), ZoneOffset.UTC));
                searchResult.setExactArrivalDate(LocalDateTime.ofInstant(flightWithBestPrice.getATimeUTC(), ZoneOffset.UTC));
                return searchResult;
            }
        }
        return new SearchResult();
    }

    public List<SearchResult> getCurrentProfileStatus(AppUser user){
        UserAccountDTOMapper mapper = Mappers.getMapper(UserAccountDTOMapper.class);
        Collection<SearchParametersDTO> foundProfiles =  profilesManager.findAllProfilesFor(mapper.mapToUserAccountDTO(user));
        return foundProfiles.stream().map(o -> {
            SearchParametersDTOMapper searchParametersMapper = Mappers.getMapper(SearchParametersDTOMapper.class);
            return searchParametersMapper.mapToSearchResults(o);
        }).collect(Collectors.toList());
    }

    public SearchResult addNewProfile(AppUser user, SearchParameters searchParameters) throws IOException, InterruptedException {
         SearchParametersDTOMapper searchParametersMapper = Mappers.getMapper(SearchParametersDTOMapper.class);
         UserAccountDTO userAccountDTO = userManager.findById(user.getUserName()).get();
         SearchParametersDTO searchParametersDTO = searchParametersMapper.mapToSearchParametersDTO(searchParameters);
         searchParametersDTO.setUserAccountDTO(userAccountDTO);

         //Add querying action and setting results
        SearchResult result = getBestFlightFor(searchParameters);
        searchParametersDTO.setExactArrivalDate(result.getExactArrivalDate());
        searchParametersDTO.setExactDepartureDate(result.getExactDepartureDate());
        searchParametersDTO.setCurrentPrice(result.getCurrentPrice());
        result = searchParametersMapper.mapToSearchResults(searchParametersDTO);
        profilesRepository.saveAndFlush(searchParametersDTO);

        return result;
    }




}
