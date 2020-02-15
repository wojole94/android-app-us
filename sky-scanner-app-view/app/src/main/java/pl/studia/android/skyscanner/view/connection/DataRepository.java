package pl.studia.android.skyscanner.view.connection;

import java.util.List;
import java.util.Map;

import io.reactivex.Completable;
import pl.studia.android.skyscanner.view.datamodel.ProfileData;
import pl.studia.android.skyscanner.view.datamodel.ProfileRequest;
import pl.studia.android.skyscanner.view.datamodel.ProfileResponse;
import pl.studia.android.skyscanner.view.datamodel.UserData;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface DataRepository {
    public Map<Integer, ProfileData> getProfiles(UserData user);
    public ProfileData addProfile(UserData user, ProfileData profile);
    public List<String> getCitiesList();
    public void removeProfile(UserData user, ProfileData profile);
    public Map<String, List<String>> getCountries();

//    @GET("/flight/getProfiles")
//    public Call<List<ProfileResponse>> getAllProfiles(@Query("username") String email, @Query("password") String password);
    @GET("/flight/getProfiles")
    public Call<List<ProfileData>> getAllProfiles(@Query("username") String email, @Query("password") String password);
    @PUT("/flight/updateProfiles")
    public Call<ProfileData> addProfile(@Query("email")String email, @Query("password")String password, @Body ProfileRequest profile);
    @DELETE("/flight/removeProfile")
    public Call<Boolean> removeProfile(@Query("email")String email, @Query("password")String password, @Query("profileId") Integer profileId);
    @GET("/user/getUser")
    public Call<UserData> getUserByEmail(@Query("email")String email);


}
