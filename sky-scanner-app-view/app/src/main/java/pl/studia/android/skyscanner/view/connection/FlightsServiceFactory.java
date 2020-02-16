package pl.studia.android.skyscanner.view.connection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import okhttp3.OkHttpClient;

public class FlightsServiceFactory {
    private static FlightsService flightsService;
    private static final String BASE_URL = "http://10.0.2.2:8080/";


    public static FlightsService makeService() {
        if (flightsService == null) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.level(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient httpClient = new OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .retryOnConnectionFailure(false)
                    .build();
//            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm").create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(httpClient)
                    .build();
            flightsService = retrofit.create(FlightsService.class);
        }
        return flightsService;
    }
}
