package pl.studia.android.skyscanner.view.connection;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import pl.studia.android.skyscanner.view.datamodel.ProfileData;
import pl.studia.android.skyscanner.view.datamodel.UserData;

public class HashMapDataRepository implements DataRepository{
    //Only mocked data structure
    Map<UserData, List<ProfileData>> dataSource;
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


   public List<ProfileData> getProfiles(UserData user){
        //Getting data from external server here
       List<ProfileData> profilesList = dataSource.get(user);
       if (profilesList == null){
           profilesList = new LinkedList<ProfileData>();
           dataSource.put(user, profilesList);
       }
        return profilesList;
    }

    public ProfileData addProfile(UserData user, ProfileData profile){
        List<ProfileData> profilesList = dataSource.get(user);
        if (profilesList == null){
            profilesList = new LinkedList<ProfileData>();
        }
        profilesList.add(profile);
        dataSource.put(user, profilesList);

        return profile;
    }

}
