package pl.studia.android.skyscanner.view.mocks;

import pl.studia.android.skyscanner.view.datamodel.UserData;

public class UsersServiceMock {
    static UserData userInstance;

    public static UserData getSampleUser() {
        if(userInstance == null) {
            UserData user = new UserData();
            user.setPassword("xyzHaslo");
            user.setEmail("login1@email.com");
            userInstance = user;
        }
        return userInstance;
    }
}
