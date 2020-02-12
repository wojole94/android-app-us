package pl.studia.android.skyscanner.backend.db.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.studia.android.skyscanner.backend.db.model.UserAccountDTO;
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

    public Optional<UserAccountDTO> findById(String email){
        return userAccountRepository.findById(email);
    }

    public List<UserAccountDTO> findAll(){
        return userAccountRepository.findAll();
    }

    public UserAccountDTO save(UserAccountDTO userAccountDTO){
        return userAccountRepository.save(userAccountDTO);
    }



    @EventListener(ApplicationReadyEvent.class)
    public void fillDb(){
        UserAccountDTO userAccountDTO = new UserAccountDTO();
        userAccountDTO.setFirstName("Jan");
        userAccountDTO.setLastName("Kowalski");
        userAccountDTO.setEmail("jan@web.pl");
        userAccountDTO.setPassword("jan1");
        save(userAccountDTO);
        userAccountDTO.setFirstName("Janusz");
        userAccountDTO.setLastName("Programowania");
        userAccountDTO.setEmail("janusz@web.pl");
        userAccountDTO.setPassword("janusz1");
        save(userAccountDTO);
    }
}
