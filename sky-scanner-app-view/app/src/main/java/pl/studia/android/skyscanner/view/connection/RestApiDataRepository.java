package pl.studia.android.skyscanner.view.connection;

import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import pl.studia.android.skyscanner.view.datamodel.ProfileData;
import pl.studia.android.skyscanner.view.datamodel.UserData;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;

public class RestApiDataRepository implements DataRepository {
    List<UserData> userDataList;
    static RestApiDataRepository INSTANCE;

    private RestApiDataRepository(){
        userDataList = new ArrayList<>();
    }

    public static  RestApiDataRepository getInstance(){
        if (INSTANCE == null){
            INSTANCE = new RestApiDataRepository();
        }
        return INSTANCE;
    }

    @Override
    public Map<Integer, ProfileData> getProfiles(UserData user) {
        return null;
    }

    @Override
    public ProfileData addProfile(UserData user, ProfileData profile) {
        return null;
    }

    @Override
    public List<String> getCitiesList() {
        return null;
    }

    @Override
    public void removeProfile(UserData user, ProfileData profile) {

    }

    @Override
    public Map<String, List<String>> getCountries() {
        return null;
    }

    @Override
    public Call<UserData> getUser(String email) {
//        UserData userData = RetrofitClientInstance.getRetrofitInstance().create(UserData.class);
//        Response<UserData> response = null;
//        try {
//            response = RetrofitClientInstance.getRetrofitInstance().create(UserData.class).getUser().execute();
//        } catch (IOException e) {
//            //TODO exception handler
//            e.printStackTrace();
//        }
//        return response.body();
        return null;
    }
}
