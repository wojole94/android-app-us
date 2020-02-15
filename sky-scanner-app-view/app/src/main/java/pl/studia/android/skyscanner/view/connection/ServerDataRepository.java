package pl.studia.android.skyscanner.view.connection;

import java.util.List;
import java.util.Map;

import pl.studia.android.skyscanner.view.datamodel.ProfileData;
import pl.studia.android.skyscanner.view.datamodel.ProfileRequest;
import pl.studia.android.skyscanner.view.datamodel.ProfileResponse;
import pl.studia.android.skyscanner.view.datamodel.UserData;
import retrofit2.Call;

public class ServerDataRepository implements DataRepository {

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
    public Call<List<ProfileResponse>> getAllProfiles(String email, String password) {
        return null;
    }

    @Override
    public Call<ProfileResponse> addProfile(String email, String password, ProfileRequest profile) {
        return null;
    }

    @Override
    public Call<Boolean> removeProfile(String email, String password, ProfileResponse profileResponse) {
        return null;
    }

    @Override
    public Call<UserData> getUserByEmail(String email) {
        return null;
    }


}
