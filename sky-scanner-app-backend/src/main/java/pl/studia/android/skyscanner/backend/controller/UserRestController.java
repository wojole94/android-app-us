package pl.studia.android.skyscanner.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pl.studia.android.skyscanner.backend.db.manager.UserAccountDatabaseManager;
import pl.studia.android.skyscanner.backend.db.model.UserAccountDTO;

import java.util.Optional;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserRestController {

    private UserAccountDatabaseManager userAccountDatabaseManager;

    @Autowired
    public UserRestController(UserAccountDatabaseManager userAccountDatabaseManager){
        this.userAccountDatabaseManager = userAccountDatabaseManager;
    }

    @GetMapping("/getUsers")
    public Iterable<UserAccountDTO> getAll() {
        return userAccountDatabaseManager.findAll();
    }

    @GetMapping("/getUser")
    public Optional<UserAccountDTO> get(@RequestParam String email) {
        return userAccountDatabaseManager.findById(email);
    }

    @PostMapping("/auth")
    public Boolean authentication(@Valid @RequestBody UserAccountDTO userAccountDTOToValidate){
        Boolean isValid = false;
        Optional<UserAccountDTO> usAcInDb = userAccountDatabaseManager.findById(userAccountDTOToValidate.getEmail());
        if(usAcInDb.isPresent()){
            UserAccountDTO userAccountDTOInDb = usAcInDb.get();
            if(userAccountDTOInDb.getPassword().equals(userAccountDTOToValidate.getPassword()))
                isValid = true;
        }
        return isValid;
    }

//TODO check
    @PostMapping
    public UserAccountDTO add(@RequestBody UserAccountDTO userAccountDTO) {
        return userAccountDatabaseManager.save(userAccountDTO);
    }

    @PutMapping("/put")
    public UserAccountDTO update(@RequestBody UserAccountDTO userAccount) {
        return userAccountDatabaseManager.save(userAccount);
    }
}
