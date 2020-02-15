package pl.studia.android.skyscanner.view.mocks;

import pl.studia.android.skyscanner.view.datamodel.UserData;

public class UsersServiceMock {
    static UserData userInstance;

    public static UserData getSampleUser() {
        if(userInstance == null) {
            UserData user = new UserData();
            user.setFirstName("Jan");
            user.setLastName("Kowalski");
            user.setPassword("jan1");
            user.setEmail("jan@web.pl");
            userInstance = user;
        }
        return userInstance;
    }
}
