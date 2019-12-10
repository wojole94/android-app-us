package pl.studia.android.skyscanner.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import pl.studia.android.skyscanner.backend.model.ModelRepository;
import pl.studia.android.skyscanner.backend.model.TestModelClass;
import java.util.List;
import javax.validation.Valid;


@RestController
@RequestMapping("/api/v1")
public class RestApiController {

    @Autowired
    ModelRepository testRepository;

    @GetMapping("/subscriptions")
    public List<TestModelClass> getAllUsers() {
        return testRepository.findAll();
    }

    @GetMapping("/subs")
    public List<TestModelClass> getSimpleUsers() {
        return testRepository.findAll();
    }

    @PostMapping("/subscriptions")
    public TestModelClass createSubscription(@Valid @RequestBody TestModelClass subscription){
        return testRepository.save(subscription);
    }




}