package pl.studia.android.skyscanner.backend.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.studia.android.skyscanner.backend.db.model.SearchParameters;

public interface SearchParamtersRepository extends JpaRepository<SearchParameters, Integer> {
}
