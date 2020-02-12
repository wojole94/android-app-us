package pl.studia.android.skyscanner.backend.connector;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import pl.studia.android.skyscanner.backend.db.model.SearchParametersDTO;
import pl.studia.android.skyscanner.backend.kiwi.model.PostAttr;
import pl.studia.android.skyscanner.backend.kiwi.model.PostQuery;
import pl.studia.android.skyscanner.backend.kiwi.model.flightPost.SearchDetail;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Date;
import java.time.ZoneId;
import java.util.List;

public class KiwiConnection {

    public List<SearchDetail[]> performSearchRequest(SearchParametersDTO searchParameters) throws IOException,
        InterruptedException {

        PostAttr postAttr = new PostAttr(
            searchParameters.getFlyFrom(),
            searchParameters.getFlyTo(),
            Date.from(searchParameters.getDateFrom().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()),
            Date.from(searchParameters.getDateTo().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()),
            null,
            searchParameters.getAdults() + searchParameters.getChildren(),
            searchParameters.getAdults(),
            searchParameters.getChildren(),
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
        return objectMapper.readValue(response.body(), new TypeReference<List<SearchDetail[]>>() {});

    }



}
