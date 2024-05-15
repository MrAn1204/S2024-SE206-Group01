package se206.group01.mobileworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import se206.group01.mobileworld.model.Product;
import se206.group01.mobileworld.model.User;
import se206.group01.mobileworld.model.UserTemplate;
import se206.group01.mobileworld.repository.ProductRepository;
import se206.group01.mobileworld.repository.UserRepository;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    UserRepository userRepository;
    
    @Autowired
    ProductRepository productRepository;

    @GetMapping(value = "/")
    public String homepage(Model model) {
        List<Product> productList = productRepository.findAll();
        model.addAttribute("productList", productList);
        return "homepage";
    }

    @GetMapping(value = "/type/{productType}")
    public String showProductsByType(@PathVariable(value = "productType") String productType, Model model) {
        List<Product> productList = productRepository.findByProductType(productType);
        model.addAttribute("product", productList);
        return "homepage";
    }

    @GetMapping(value = "/product/{id}")
    public String productDetail(@PathVariable(value = "id") Long id, Model model) {
        Product productDetail = productRepository.getById(id);
        model.addAttribute("productDetail", productDetail);
        return "productdetail";
    }
    @RequestMapping(value = "/search")
    public String showSearchPopup(Model model) {
        return "search";
    }

    @RequestMapping(value = "/cart")
    public String showCart(Model model) {
        return "cart1";
    }

    // @GetMapping(value = "/")
    // public String homePage() {
    //     return "homepage";
    // }

    @GetMapping(value = "/close")
    public String closePopUp() {
        return "homepage";
    }

    @GetMapping(value = "/sort")
    public String sort() {
        return "sort";
    }

    @GetMapping("/profile")
    public String getProfile(Model model, Authentication authentication) {
        // System.out.println(authentication.getPrincipal());
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User user = userRepository.findByUsername(userDetails.getUsername()).get();

        UserTemplate userTemplate = new UserTemplate(user);

        model.addAttribute("user", user);
        model.addAttribute("userTemplate", userTemplate);

        return "profile";
    }

    @GetMapping("/profile-edit")
    public String editProfile(Model model, Authentication authentication) {
        // System.out.println(authentication.getPrincipal());
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User user = userRepository.findByUsername(userDetails.getUsername()).get();

        UserTemplate userTemplate = new UserTemplate(user);

        model.addAttribute("user", user);
        model.addAttribute("userTemplate", userTemplate);

        return "profileEdit";
    }

    @PostMapping("/profile-edit")
    public String updateProfile(Model model, @Valid UserTemplate userTemplate, BindingResult result, Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User user = userRepository.findByUsername(userDetails.getUsername()).get();
        model.addAttribute("user", user);

        System.out.println(result);

        // username, password, and confirmPassword are empty. They will be ignore since user cannot edit them
        if (result.getErrorCount() > 3) {
            return "profileEdit";
        } else {
            user.updateFields(userTemplate);
            userRepository.save(user);
            return "redirect:/profile";
        }
    }
}

