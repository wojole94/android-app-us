package pl.studia.android.skyscanner.backend.mapping;

import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
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
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Collection;
import java.util.Date;
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

    private static final Logger log = LoggerFactory.getLogger(DataExtractor.class);

    public SearchResult getBestFlightFor(SearchParameters searchParameters) throws IOException, InterruptedException {
        SearchParametersDTOMapper mapper = Mappers.getMapper(SearchParametersDTOMapper.class);
        return getBestFlightFor(mapper.mapToSearchParametersDTO(searchParameters));
    }

    public SearchResult getBestFlightFor(SearchParametersDTO searchParametersDTO) throws IOException, InterruptedException {
        KiwiConnection connection = new KiwiConnection();
        List<SearchDetail[]> searchDetailsList =
            connection.performSearchRequest(searchParametersDTO);
        return getBestFlight(searchDetailsList, searchParametersDTO);
    }

    private SearchResult getBestFlight(List<SearchDetail[]> listOfResults, SearchParametersDTO searchParametersDTO) {
        SearchParametersDTOMapper mapper = Mappers.getMapper(SearchParametersDTOMapper.class);
        log.info("Recieved results: {}", listOfResults.size());
        for (SearchDetail[] searchDetailArray : listOfResults) {
            if (searchDetailArray != null && searchDetailArray.length > 0) {
                Flights flights = new Flights(searchDetailArray);//TODO - narazie zawsze odczytuje jedno połączenie
                SearchDetail flightWithBestPrice = flights.getFlightWithBestPrice();
                SearchResult searchResult = mapper.mapToSearchResults(searchParametersDTO);
                searchResult.setCurrentPrice(flightWithBestPrice.getPrice());
                searchResult.setExactDepartureDate(LocalDateTime.ofInstant(flightWithBestPrice.getDTimeUTC(), ZoneOffset.UTC));
                searchResult.setExactArrivalDate(LocalDateTime.ofInstant(flightWithBestPrice.getATimeUTC(), ZoneOffset.UTC));
                return searchResult;
            }
        }
        SearchResult searchResult = mapper.mapToSearchResults(searchParametersDTO);
        searchResult.setCurrentPrice(0);
        searchResult.setExactDepartureDate(LocalDateTime.now());
        searchResult.setExactArrivalDate(LocalDateTime.now());
        return searchResult;
    }

    public List<SearchResult> getCurrentProfileStatus(AppUser user){
        UserAccountDTOMapper mapper = Mappers.getMapper(UserAccountDTOMapper.class);
        Collection<SearchParametersDTO> foundProfiles =  profilesManager.findAllProfilesFor(mapper.mapToUserAccountDTO(user));
        return foundProfiles.stream().map(o -> {
            SearchParametersDTOMapper searchParametersMapper = Mappers.getMapper(SearchParametersDTOMapper.class);
            return searchParametersMapper.mapToSearchResults(o);
        }).collect(Collectors.toList());
    }

    public SearchResult upsertProfile(AppUser user, SearchParameters searchParameters) throws IOException, InterruptedException {
         SearchParametersDTOMapper searchParametersMapper = Mappers.getMapper(SearchParametersDTOMapper.class);
         UserAccountDTO userAccountDTO = userManager.findById(user.getUserName()).get();
         SearchParametersDTO searchParametersDTO = searchParametersMapper.mapToSearchParametersDTO(searchParameters);
         searchParametersDTO.setUserAccountDTO(userAccountDTO);

         //Add querying action and setting results
        SearchResult result = getBestFlightFor(searchParameters);
        searchParametersDTO.setExactArrivalDate(result.getExactArrivalDate());
        searchParametersDTO.setExactDepartureDate(result.getExactDepartureDate());
        searchParametersDTO.setCurrentPrice(result.getCurrentPrice());
        SearchParametersDTO parametersRecord;

        Optional<SearchParametersDTO> existing =
            profilesRepository
                .findAll()
                .stream()
                .filter(o -> o.getId() != null ? o.getId().equals(searchParametersDTO.getId()) : false)
                .findFirst();
        if(!existing.isPresent()){
            parametersRecord = profilesRepository.save(searchParametersDTO);
        }
        else {
            SearchParametersDTO existingItem = existing.get();
            searchParametersDTO.setId(existingItem.getId());
            parametersRecord = profilesRepository.save(searchParametersDTO);
        }

        return searchParametersMapper.mapToSearchResults(parametersRecord);
    }

    public SearchResult removeProfile(AppUser user, SearchParameters searchParameters) throws IOException, InterruptedException {
        SearchParametersDTOMapper searchParametersMapper = Mappers.getMapper(SearchParametersDTOMapper.class);
        UserAccountDTO userAccountDTO = userManager.findById(user.getUserName()).get();

        SearchParametersDTO parametersRecord = searchParametersMapper.mapToSearchParametersDTO(searchParameters);
        profilesRepository.delete(parametersRecord);
        parametersRecord.setId(null);

        return searchParametersMapper.mapToSearchResults(parametersRecord);
    }

    @Scheduled(fixedRate = 10000)
    public void performDataRefresh() {
        SearchParametersDTOMapper searchParametersMapper = Mappers.getMapper(SearchParametersDTOMapper.class);
        profilesRepository.findAll().stream().forEach(o ->{
            try {
                log.info("Performing refresh call for {}", o.getId());
                SearchResult results = getBestFlightFor(o);
                SearchParametersDTO updatedRecord = searchParametersMapper.mapToSearchParametersDTO(results);
                updatedRecord.setUserAccountDTO(userManager.findById(o.getUserAccountDTO().getEmail()).get());
                profilesRepository.save(updatedRecord);
            } catch (IOException e) {
                log.error("Error during getting data from kiwi: ",e);
            } catch (InterruptedException e) {
                log.error("Error during getting data from kiwi: ",e);
            }
        });
    }


}
