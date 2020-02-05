package pl.studia.android.skyscanner.view.datamodel;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserData implements Serializable {
    String username;
    String password;

}
