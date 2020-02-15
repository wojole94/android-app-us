package pl.studia.android.skyscanner.view.datamodel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserData {

    String email;
    String password;
//    @SerializedName("first_name")
    String firstName;
//    @SerializedName("last_name")
    String lastName;

}
