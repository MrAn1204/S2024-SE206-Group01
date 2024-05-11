package se206.group01.mobileworld.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import se206.group01.mobileworld.model.User;
import se206.group01.mobileworld.repository.UserRepository;

@Controller
public class AuthenController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String loginHandle(Model model, @Valid User user, BindingResult result) {
        System.out.println(result);
        if (!result.hasErrors()) {
            Optional<User> u = userRepository.findByUsername(user.getUsername());
            if (u.isPresent()) {;
                if (user.getPassword().equals(u.get().getPassword())) {
                    model.addAttribute("user", user);
                    return "index";
                }
            }
        }
        model.addAttribute("user", user);
        return "login";
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String signupHandle(Model model, @Valid User user, BindingResult result) {
        List<User> users = userRepository.findAll();
        System.out.println(users);

        for (User u : users) {
            if (u.getUsername().equals(user.getUsername())) {
                model.addAttribute("user", user);
                return "signup";
            }
        }

        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "signup";
        } else {
            userRepository.save(user);
            return "login";
        }
    }
}
