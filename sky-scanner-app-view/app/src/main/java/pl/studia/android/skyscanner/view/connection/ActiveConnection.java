package pl.studia.android.skyscanner.view.connection;

import pl.studia.android.skyscanner.view.datamodel.UserData;

public class ActiveConnection {
    static ActiveConnection instance;
    UserData userData;

    private ActiveConnection(){

    }

    public static ActiveConnection getInstance() {
        if(instance==null){
            instance = new ActiveConnection();
        }
        return instance;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }
}
