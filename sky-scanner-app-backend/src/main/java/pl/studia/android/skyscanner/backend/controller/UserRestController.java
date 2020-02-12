package pl.studia.android.skyscanner.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pl.studia.android.skyscanner.backend.db.manager.UserAccountManager;
import pl.studia.android.skyscanner.backend.db.model.UserAccountDTO;

import java.util.Optional;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserRestController {

    private UserAccountManager userAccountManager;

    @Autowired
    public UserRestController(UserAccountManager userAccountManager){
        this.userAccountManager = userAccountManager;
    }

    @GetMapping("/getUsers")
    public Iterable<UserAccountDTO> getAll() {
        return userAccountManager.findAll();
    }

    @GetMapping("/getUser")
    public Optional<UserAccountDTO> get(@RequestParam String email) {
        return userAccountManager.findById(email);
    }

    @PostMapping("/auth")
    public Boolean authentication(@Valid @RequestBody UserAccountDTO userAccountDTOToValidate){
        Boolean isValid = false;
        Optional<UserAccountDTO> usAcInDb = userAccountManager.findById(userAccountDTOToValidate.getEmail());
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
        return userAccountManager.save(userAccountDTO);
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
