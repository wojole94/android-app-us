package pl.studia.android.skyscanner.backend.mapping;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import pl.studia.android.skyscanner.backend.db.model.UserAccountDTO;
import pl.studia.android.skyscanner.backend.model.AppUser;

@Mapper
public interface UserAccountDTOMapper {
    @Mappings({
        @Mapping(source = "userName", target = "email")
    })
    public UserAccountDTO mapToUserAccountDTO(AppUser user);
}
