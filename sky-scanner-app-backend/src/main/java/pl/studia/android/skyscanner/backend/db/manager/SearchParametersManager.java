package pl.studia.android.skyscanner.backend.db.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.studia.android.skyscanner.backend.db.model.SearchParametersDTO;
import pl.studia.android.skyscanner.backend.db.model.UserAccountDTO;
import pl.studia.android.skyscanner.backend.db.repository.SearchParametersRepository;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Service
public class SearchParametersManager {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private SearchParametersRepository repository;

    public List<SearchParametersDTO> findAllProfilesFor(UserAccountDTO user){
        return repository.findAll().stream().filter(elem -> {
            UserAccountDTO accountDTO = elem.getUserAccountDTO();
            if(accountDTO != null && accountDTO.getEmail() != null) {
                return accountDTO.getEmail().equals(user.getEmail());
            }
            return false;
        }).collect(Collectors.toList());

    }

}
