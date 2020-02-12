package pl.studia.android.skyscanner.backend.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppUser {
    @JsonProperty("user_name")
    String userName;
    @JsonProperty("password")
    String password;

}
