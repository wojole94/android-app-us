package pl.studia.android.skyscanner.backend.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import pl.studia.android.skyscanner.backend.db.model.SearchParametersDTO;
import pl.studia.android.skyscanner.backend.model.SearchParameters;
import pl.studia.android.skyscanner.backend.model.SearchResult;

@Mapper
public interface SearchParametersDTOMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "cityFrom", target = "flyFrom"),
            @Mapping(source = "cityTo", target = "flyTo"),
            @Mapping(source = "searchStartDate", target = "dateFrom"),
            @Mapping(source = "searchEndDate", target = "dateTo"),
            @Mapping(source = "transfersNumber", target = "transfersCount"),
            @Mapping(source = "adultsNumber", target = "adults"),
            @Mapping(source = "childrenNumber", target = "children"),
            @Mapping(source = "maximumPrice", target = "maximumPrice"),
            @Mapping(source = "onlyWeekendFlights", target = "onlyWeekends"),
            @Mapping(source = "deepLink", target = "deepLink"),
            @Mapping(source = "exactArrivalDate", target = "exactArrivalDate"),
            @Mapping(source = "exactDepartureDate", target = "exactDepartureDate"),
            @Mapping(source = "currentPrice", target = "currentPrice"),
            @Mapping(source = "realTransfersNumber", target = "realTransfersNumber")

    })
    SearchParametersDTO mapToSearchParametersDTO(SearchParameters searchResult);

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "cityFrom", source = "flyFrom"),
            @Mapping(target = "cityTo", source = "flyTo"),
            @Mapping(target = "searchStartDate", source = "dateFrom"),
            @Mapping(target = "searchEndDate", source = "dateTo"),
            @Mapping(target = "transfersNumber", source = "transfersCount"),
            @Mapping(target = "adultsNumber", source = "adults"),
            @Mapping(target = "childrenNumber", source = "children"),
            @Mapping(target = "maximumPrice", source = "maximumPrice"),
            @Mapping(target = "onlyWeekendFlights", source = "onlyWeekends"),
            @Mapping(target = "deepLink", source = "deepLink"),
            @Mapping(target = "exactArrivalDate", source = "exactArrivalDate"),
            @Mapping(target = "exactDepartureDate", source = "exactDepartureDate"),
            @Mapping(target = "currentPrice", source = "currentPrice"),
            @Mapping(target = "realTransfersNumber", source = "realTransfersNumber")

    })
    SearchParameters mapToSearchParameters(SearchParametersDTO searchParametersDTO);

    @Mappings({})
    SearchResult mapToSearchResults(SearchParametersDTO searchResult);

    @Mappings({})
    SearchParametersDTO mapToSearchParametersDTO(SearchResult searchResult);
}
