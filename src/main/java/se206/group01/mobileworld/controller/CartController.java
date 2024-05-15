
package se206.group01.mobileworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import se206.group01.mobileworld.repository.UserRepository;

@Controller
public class CartController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/shipment")
    public String showShipment(Model model) {
        return "cart2";
    }

    @GetMapping("/payment")
    public String showPayment() {
        return "cart3";
    }

    @GetMapping("/complete")
    public String showComplete() {
        return "cart4";
    }
}
