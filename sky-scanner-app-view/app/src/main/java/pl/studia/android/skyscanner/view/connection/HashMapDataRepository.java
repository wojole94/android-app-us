package pl.studia.android.skyscanner.view.connection;

import java.util.HashMap;
import java.util.Map;

import pl.studia.android.skyscanner.view.datamodel.ProfileData;
import pl.studia.android.skyscanner.view.datamodel.UserData;

public class HashMapDataRepository implements DataRepository{
    //Only mocked data structure
    Map<UserData, Map<Integer,ProfileData>> dataSource;
    static HashMapDataRepository INSTANCE;

    private HashMapDataRepository(){
        dataSource = new HashMap<>();
    }

    public static HashMapDataRepository getInstance(){
        if (INSTANCE == null){
            INSTANCE = new HashMapDataRepository();
        }
        return INSTANCE;
    }


   public Map<Integer, ProfileData> getProfiles(UserData user){
        //Getting data from external server here
       Map<Integer, ProfileData> profilesList = dataSource.get(user);
       if (profilesList == null){
           profilesList = new HashMap<>();
           dataSource.put(user, profilesList);
       }
        return profilesList;
    }

    public ProfileData addProfile(UserData user, ProfileData profile){
        Map<Integer, ProfileData> profilesList = dataSource.get(user);
        if (profilesList == null){
            profilesList = new HashMap<>();
        }
        profilesList.put(profile.hashCode(),profile);
        dataSource.put(user, profilesList);

        return profile;
    }

}
