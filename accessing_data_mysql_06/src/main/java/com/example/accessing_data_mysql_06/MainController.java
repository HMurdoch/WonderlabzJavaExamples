package com.example.accessing_data_mysql_06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/user")
public class MainController {
    // This gets the UserRepository Bean and assigns it to userRepository
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path="/add")
    // ResponseBody means that the returned String is the response, not the view name
    public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return "User: " + name + " Email: " + email + " - Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
