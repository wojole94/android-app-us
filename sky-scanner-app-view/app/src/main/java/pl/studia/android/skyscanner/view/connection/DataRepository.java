package pl.studia.android.skyscanner.view.connection;

import java.util.List;
import java.util.Map;
import java.util.Set;

import pl.studia.android.skyscanner.view.datamodel.ProfileData;
import pl.studia.android.skyscanner.view.datamodel.UserData;

public interface DataRepository {
    public Map<Integer, ProfileData> getProfiles(UserData user);
    public ProfileData addProfile(UserData user, ProfileData profile);
    public List<String> getCitiesList();
    public Map<String, List<String>> getCountries();

}
