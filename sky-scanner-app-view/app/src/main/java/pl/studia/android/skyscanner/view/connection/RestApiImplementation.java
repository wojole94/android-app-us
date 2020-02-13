package pl.studia.android.skyscanner.view.connection;

import com.google.gson.JsonObject;

import java.util.ArrayList;

import pl.studia.android.skyscanner.view.datamodel.UserData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;

public class RestApiImplementation {
    static RestApiImplementation INSTANCE;

    private RestApiImplementation(){
    }

    public static  RestApiImplementation getInstance(){
        if (INSTANCE == null){
            INSTANCE = new RestApiImplementation();
        }
        return INSTANCE;
    }

    public UserData getUser(String email) {
//        UserData userData = RetrofitClientInstance.getRetrofitInstance().create(DataRepository.class);
        DataRepository dataRepository = RetrofitClientInstance.getRetrofitInstance().create(DataRepository.class);
        Call<UserData> call = dataRepository.getUser(email);
        UserData user = new UserData();
        call.enqueue(new Callback<UserData>() {

            @Override
            public void onResponse(Call<UserData> call, Response<UserData> response) {
                int i=0;
            }

            @Override
            public void onFailure(Call<UserData> call, Throwable t) {
                int i=0;
            }
        });
        return user;
    }
}
