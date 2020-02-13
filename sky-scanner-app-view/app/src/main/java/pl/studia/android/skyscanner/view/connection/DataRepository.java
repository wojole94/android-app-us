package pl.studia.android.skyscanner.view.connection;

import com.google.gson.JsonObject;

import java.util.List;
import java.util.Map;
import java.util.Set;

import pl.studia.android.skyscanner.view.datamodel.ProfileData;
import pl.studia.android.skyscanner.view.datamodel.UserData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DataRepository {

    public Map<Integer, ProfileData> getProfiles(UserData user);
    public ProfileData addProfile(UserData user, ProfileData profile);
    public List<String> getCitiesList();
    public void removeProfile(UserData user, ProfileData profile);
    public Map<String, List<String>> getCountries();
    @GET("user/getUser")
    public Call<UserData> getUser(@Query("email") String email) ;
}
