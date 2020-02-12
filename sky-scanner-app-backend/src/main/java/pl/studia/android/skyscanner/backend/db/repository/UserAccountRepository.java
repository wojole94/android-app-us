package pl.studia.android.skyscanner.backend.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import pl.studia.android.skyscanner.backend.db.model.UserAccountDTO;

@Transactional
public interface UserAccountRepository extends JpaRepository<UserAccountDTO, String> {

}
