package pl.studia.android.skyscanner.backend.db.manager;

import pl.studia.android.skyscanner.backend.db.model.UserAccountDTO;

import java.util.List;
import java.util.Optional;

public interface UserAccountService {
    public Optional<UserAccountDTO> findById(String email);

    public List<UserAccountDTO> findAll();

    public UserAccountDTO save(UserAccountDTO userAccountDTO);
}
