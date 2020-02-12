package pl.studia.android.skyscanner.backend.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.studia.android.skyscanner.backend.db.model.UserAccountDTO;

public interface UserAccountRepository extends JpaRepository<UserAccountDTO, String> {
//    UserAccount findByUsername(String username);
}
