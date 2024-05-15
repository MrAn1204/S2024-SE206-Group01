package se206.group01.mobileworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {
    @GetMapping("/cart2")
    public String showCart2(Model model) {
        return "cart2";
    }

    @GetMapping("/cart3")
    public String showCart3() {
        return "cart3";
    }

    @GetMapping("/cart4")
    public String showCart4() {
        return "cart4";
    }
    @GetMapping("/close")
    public String showCart5() {
        return "homapage";
    }
}
