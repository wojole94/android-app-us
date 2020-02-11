package pl.studia.android.skyscanner.backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.studia.android.skyscanner.backend.db.manager.UserAccountManager;
import pl.studia.android.skyscanner.backend.db.model.UserAccount;
import pl.studia.android.skyscanner.backend.model.SearchParameters;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserRestController {

    private UserAccountManager userAccountManager;

    @Autowired
    public UserRestController(UserAccountManager userAccountManager){
        this.userAccountManager = userAccountManager;
    }

    @GetMapping("/getUsers")
    public Iterable<UserAccount> getAll() {
        return userAccountManager.findAll();
    }

    @GetMapping("/getUser")
    public Optional<UserAccount> get(@RequestParam String email) {
        return userAccountManager.findById(email);
    }

    @PostMapping("/auth")
    public Boolean authentication(@Valid @RequestBody UserAccount userAccountToValidate){
        Boolean isValid = false;
        Optional<UserAccount> usAcInDb = userAccountManager.findById(userAccountToValidate.getEmail());
        if(usAcInDb.isPresent()){
            UserAccount userAccountInDb = usAcInDb.get();
            if(userAccountInDb.getPassword().equals(userAccountToValidate.getPassword()))
                isValid = true;
        }
        return isValid;
    }

//TODO check
    @PostMapping
    public UserAccount add(@RequestBody UserAccount userAccount) {
        return userAccountManager.save(userAccount);
    }
//
//    @PutMapping
//    public UserAccount update(@RequestBody UserAccount userAccount) {
//        return userAccountManager.save(userAccount);
//    }
//
//    @DeleteMapping
//    public void delete(@RequestParam Long index) {
//        userAccountManager.deleteById(index);
//    }
}
