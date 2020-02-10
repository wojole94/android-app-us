package pl.studia.android.skyscanner.backend.kiwi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class KiwiController {

/*    @GetMapping("/sendPost")
    public void sendPost() throws IOException {
        PostAttr postAttr = new PostAttr(      "MAD", "DXB",
                LocalDate.now(),
                LocalDate.now(),
                null,
                2,
                2,
                0);
        PostQuery postQuery = new PostQuery();
        postQuery.addToPostQuery(postAttr);

        //        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("https://api.skypicker.com/flights_multi?partner=picky&locale=pl&curr=PLN"))
//                .POST(HttpRequest.BodyPublishers.ofString(requestBody))

//                .build();
//
//        HttpResponse<String> response = client.send(request,
//                HttpResponse.BodyHandlers.ofString());
//
//        SearchDetail[] flightDetails = objectMapper.readValue(response.body(), SearchDetail[].class);
//        System.out.println(response.body());

        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(postQuery);
        File file = new File("flightResponse.json");
        SearchDetail[][] flightDetails = objectMapper.readValue(file, SearchDetail[][].class);
        System.out.println(Arrays.deepToString(flightDetails));
    }*/
}
