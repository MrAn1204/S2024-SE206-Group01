package se206.group01.mobileworld.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import se206.group01.mobileworld.model.User;
import se206.group01.mobileworld.model.UserTemplate;
import se206.group01.mobileworld.repository.UserRepository;

@Controller
public class AuthenController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("userTemplate", new UserTemplate());
        return "login";
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("userTemplate", new UserTemplate());
        return "signup";
    }

    @PostMapping("/signup")
    public String signupHandle(Model model, @Valid UserTemplate userTemplate, BindingResult result) {
        List<User> users = userRepository.findAll();

        for (User user : users) {
            if (user.getUsername().equals(userTemplate.getUsername())) {
                result.rejectValue("username", "error.userTemplate.username", "Username is already taken");
                model.addAttribute("userTemplate", userTemplate);
                return "signup";
            }
        }

        if (!userTemplate.getPassword().equals(userTemplate.getConfirmPassword())) {
            result.rejectValue("confirmPassword", "error.userTemplate.confirmPassword", "Passwords do not match");
            model.addAttribute("userTemplate", userTemplate);
            return "signup";
        }

        if (result.hasErrors()) {
            model.addAttribute("user", userTemplate);
            return "signup";
        } else {
            userRepository.save(new User(userTemplate));
            return "login";
        }
    }
}
