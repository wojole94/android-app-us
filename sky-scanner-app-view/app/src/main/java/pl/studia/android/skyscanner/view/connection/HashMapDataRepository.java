package pl.studia.android.skyscanner.view.connection;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

   @Override
   public Map<Integer, ProfileData> getProfiles(UserData user){
        //Getting data from external server here
       Map<Integer, ProfileData> profilesList = dataSource.get(user);
       if (profilesList == null){
           profilesList = new HashMap<>();
           dataSource.put(user, profilesList);
       }
        return profilesList;
    }


    @Override
    public ProfileData addProfile(UserData user, ProfileData profile){
        Map<Integer, ProfileData> profilesList = dataSource.get(user);
        if (profilesList == null){
            profilesList = new HashMap<>();
        }
        profilesList.put(profile.getId(),profile);
        dataSource.put(user, profilesList);

        return profile;
    }

    @Override
    public List<String> getCitiesList() {
        LinkedList<String> citiesSet = new LinkedList<>();
        citiesSet.add("NONE");
        citiesSet.add("KTW");
        citiesSet.add("IEV");
        citiesSet.add("KRA");
        citiesSet.add("KEF");
        citiesSet.add("ROM");
        citiesSet.add("BER");
        citiesSet.add("LON");
        citiesSet.add("DEN");
        citiesSet.add("MAD");
        citiesSet.add("MAS");
        citiesSet.add("EGP");
        citiesSet.add("AKU");
        citiesSet.add("MOS");
        citiesSet.add("WAW");
        citiesSet.add("WRO");
        citiesSet.add("TOK");
        citiesSet.add("NYC");
        citiesSet.add("WAS");


        return citiesSet.stream().sorted((String::compareTo)).collect(Collectors.toList());
    }

    @Override
    public void removeProfile(UserData user, ProfileData profile) {
        Map<Integer, ProfileData> profilesList = dataSource.get(user);
        if (profilesList != null){
            profilesList.remove(profile.getId());
        }
    }


    @Override
    public Map<String, List<String>> getCountries() {
        return null;
    }


}
