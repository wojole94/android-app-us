package pl.studia.android.skyscanner.backend.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.studia.android.skyscanner.backend.db.model.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, String> {
//    UserAccount findByUsername(String username);
}
