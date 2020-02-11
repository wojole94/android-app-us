package pl.studia.android.skyscanner.backend.db.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.studia.android.skyscanner.backend.db.model.UserAccount;
import pl.studia.android.skyscanner.backend.db.repository.UserAccountRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserAccountManager {
    private UserAccountRepository userAccountRepository;

    @Autowired
    public UserAccountManager(UserAccountRepository userAccountRepository){
        this.userAccountRepository = userAccountRepository;
    }

    public Optional<UserAccount> findById(String email){
        return userAccountRepository.findById(email);
    }

    public List<UserAccount> findAll(){
        return userAccountRepository.findAll();
    }

    public UserAccount save(UserAccount userAccount){
        return userAccountRepository.save(userAccount);
    }



    @EventListener(ApplicationReadyEvent.class)
    public void fillDb(){
        UserAccount userAccount = new UserAccount();
        userAccount.setFirstName("Jan");
        userAccount.setLastName("Kowalski");
        userAccount.setEmail("jan@web.pl");
        userAccount.setPassword("jan1");
        save(userAccount);
        userAccount.setFirstName("Janusz");
        userAccount.setLastName("Programowania");
        userAccount.setEmail("janusz@web.pl");
        userAccount.setPassword("janusz1");
        save(userAccount);
    }
}
