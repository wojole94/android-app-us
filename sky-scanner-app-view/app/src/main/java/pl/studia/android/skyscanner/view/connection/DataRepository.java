package pl.studia.android.skyscanner.view.connection;

import java.util.List;

import pl.studia.android.skyscanner.view.datamodel.ProfileData;
import pl.studia.android.skyscanner.view.datamodel.UserData;

public interface DataRepository {
    public List<ProfileData> getProfiles(UserData user);
    public ProfileData addProfile(UserData user, ProfileData profile);

}
