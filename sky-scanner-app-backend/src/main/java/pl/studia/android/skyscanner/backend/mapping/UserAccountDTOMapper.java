package pl.studia.android.skyscanner.backend.mapping;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import pl.studia.android.skyscanner.backend.db.model.SearchParametersDTO;
import pl.studia.android.skyscanner.backend.db.model.UserAccountDTO;
import pl.studia.android.skyscanner.backend.model.AppUser;
import pl.studia.android.skyscanner.backend.model.SearchParameters;

public interface UserAccountDTOMapper {
    @BeanMapping(ignoreByDefault = true)
    @Mappings({
        @Mapping(source = "username", target = "email"),
    })
    public abstract UserAccountDTO mapToUserAccountDTO(AppUser user);
}
