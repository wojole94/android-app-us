package pl.studia.android.skyscanner.view.connection;

import java.util.List;
import java.util.Map;

import pl.studia.android.skyscanner.view.datamodel.ProfileData;
import pl.studia.android.skyscanner.view.datamodel.UserData;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface FlightsService {
    @GET("flight/getProfiles")
    public Call<List<ProfileData>> getAllProfiles(@Query("username") String email, @Query("password") String password);

    @GET("flight/getProfilesMap")
    public Call<Map<Integer, ProfileData>> getAllProfilesMap(@Query("username") String email, @Query("password") String password);

    @PUT("flight/updateProfiles")
    public Call<ProfileData> addProfile(@Query("email") String email, @Query("password") String password, @Body ProfileData profile);

    @DELETE("flight/removeProfile")
    public Call<Boolean> removeProfile(@Query("email") String email, @Query("password") String password, @Query("profileId") Integer profileId);

    @GET("user/getUser")
    public Call<UserData> getUserByEmail(@Query("email") String email);

    ///////////////////////////////////////////////////////////////////////


    public Map<Integer, ProfileData> getProfiles(UserData user);

    public ProfileData addProfile(UserData user, ProfileData profile);

    public void removeProfile(UserData user, ProfileData profile);

}
