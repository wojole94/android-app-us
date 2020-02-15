package pl.studia.android.skyscanner.view.connection;

import java.util.List;

import okhttp3.OkHttpClient;
import pl.studia.android.skyscanner.view.datamodel.ProfileResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SkyScannerService {

    public static ProfileResponse getAllProfiles(String email, String password) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://10.0.2.2:8080")
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(httpClient.build())
//                .build();

        DataRepository service = RetrofitClientInstance.getRetrofitInstance().create(DataRepository.class);

        Call<List<ProfileResponse>> call = service.getAllProfiles(email, password);

//        try {
//            Response<ProfileResponse> response = callSync.execute();
//            ProfileResponse apiResponse = response.body();
//            System.out.println(apiResponse);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
        System.out.println("test1");
        call.enqueue(new Callback<List<ProfileResponse>>() {

            @Override
            public void onResponse(Call<List<ProfileResponse>> call, Response<List<ProfileResponse>> response) {
                System.out.println("test2");
                List<ProfileResponse> apiResponse = response.body();

            System.out.println(apiResponse);
            }

            @Override
            public void onFailure(Call<List<ProfileResponse>> call, Throwable t) {
                System.out.println("test3");
                int i=0;
            }
        });
        System.out.println("test4");
        return null;
    }
}
