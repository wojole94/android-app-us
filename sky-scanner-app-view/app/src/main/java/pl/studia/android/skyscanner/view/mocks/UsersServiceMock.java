package pl.studia.android.skyscanner.view.mocks;

import pl.studia.android.skyscanner.view.datamodel.UserData;

public class UsersServiceMock {
    static UserData userInstance;

    public static UserData getSampleUser() {
        if(userInstance == null) {
            UserData user = new UserData();
            user.setPassword("xyz");
            user.setUsername("login1");
            userInstance = user;
        }
        return userInstance;
    }
}
