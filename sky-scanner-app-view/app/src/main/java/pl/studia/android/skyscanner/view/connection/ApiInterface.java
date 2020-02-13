package pl.studia.android.skyscanner.view.connection;

import java.util.List;

import pl.studia.android.skyscanner.view.datamodel.UserData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("user/getUsers")
    Call<List<UserData>> getUsers();
}
