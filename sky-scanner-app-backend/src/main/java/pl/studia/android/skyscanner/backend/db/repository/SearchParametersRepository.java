package pl.studia.android.skyscanner.backend.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import pl.studia.android.skyscanner.backend.db.model.SearchParametersDTO;
import pl.studia.android.skyscanner.backend.db.model.UserAccountDTO;

import java.util.Collection;

@Transactional
public interface SearchParametersRepository extends JpaRepository<SearchParametersDTO, Integer> {


}
