package pl.studia.android.skyscanner.view.datamodel;

import android.content.Context;
import android.widget.Toast;

import java.util.List;

import okhttp3.OkHttpClient;
import pl.studia.android.skyscanner.view.activity.MainActivity;
import pl.studia.android.skyscanner.view.connection.DataRepository;
import pl.studia.android.skyscanner.view.connection.HashMapDataRepository;
import pl.studia.android.skyscanner.view.connection.RetrofitClientInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginInformation {

    private UserData userData;
    private String password;
    private Boolean isLoggedIn = false;
    private static LoginInformation INSTANCE;

    private LoginInformation(){
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        DataRepository service = RetrofitClientInstance.getRetrofitInstance().create(DataRepository.class);
        Call<UserData> call = service.getUserByEmail("jan@web.pl");
        password = "jan1";

        call.enqueue(new Callback<UserData>() {
            @Override
            public void onResponse(Call<UserData> call, Response<UserData> response) {
                userData = response.body();
                if (userData != null) {
                    isLoggedIn = true;
//                    Toast.makeText(MainActivity.getContext(), "Zalogowano!", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<UserData> call, Throwable t) {
//                userData = null;
                isLoggedIn = false;
//                Toast.makeText(MainActivity.getContext(), "Błąd logowania!", Toast.LENGTH_LONG).show();
            }
        });
        if(call.isExecuted()){
            int i=0;
        }
    }


    public static LoginInformation getInstance(){
        if (INSTANCE == null){
            INSTANCE = new LoginInformation();
        }
        return INSTANCE;
    }

    public UserData getUserData() {
        return userData;
    }

    public Boolean getIsLoggedIn() {
        return isLoggedIn;
    }

    public String getPassword() {
        return password;
    }
}
