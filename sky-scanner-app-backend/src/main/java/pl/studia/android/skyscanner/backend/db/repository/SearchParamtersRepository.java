package pl.studia.android.skyscanner.backend.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pl.studia.android.skyscanner.backend.db.model.SearchParametersDTO;
import pl.studia.android.skyscanner.backend.db.model.UserAccountDTO;

import java.util.Collection;

public interface SearchParamtersRepository extends JpaRepository<SearchParametersDTO, Integer> {

    @Query("SELECT * FROM search_parameters sp WHERE sp.fk_user_account = ?1")
    Collection<SearchParametersDTO> findAllProfiles(UserAccountDTO userDTO);
}
