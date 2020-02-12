package pl.studia.android.skyscanner.backend.mapping;

import org.mapstruct.*;

import pl.studia.android.skyscanner.backend.db.model.SearchParametersDTO;
import pl.studia.android.skyscanner.backend.model.SearchParameters;
import pl.studia.android.skyscanner.backend.model.SearchResult;

@Mapper
public interface SearchParametersDTOMapper {
    @BeanMapping(ignoreByDefault = true)
    @Mappings({
        @Mapping(source = "cityFrom", target = "flyFrom"),
        @Mapping(source = "cityTo", target = "flyTo"),
        @Mapping(source = "searchStartDate", target = "dateFrom"),
        @Mapping(source = "searchEndDate", target = "dateTo"),
        @Mapping(source = "transfersNumber", target = "transfersCount"),
        @Mapping(source = "adultsNumber", target = "adults"),
        @Mapping(source = "childrenNumber", target = "children"),
        @Mapping(source = "maximumPrice", target = "maximumPrice"),
        @Mapping(source = "onlyWeekendFlights", target = "onlyWeekends")
    })
    public abstract SearchParametersDTO mapToSearchParametersDTO(SearchParameters searchResult);

    @BeanMapping(ignoreByDefault = true)
    public abstract SearchResult mapToSearchResults(SearchParametersDTO searchResult);
}
