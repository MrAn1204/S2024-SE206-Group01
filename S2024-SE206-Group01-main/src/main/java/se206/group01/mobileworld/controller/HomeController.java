package se206.group01.mobileworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import se206.group01.mobileworld.model.Product;
import se206.group01.mobileworld.repository.ProductRepository;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    ProductRepository productRepository;

    @RequestMapping(value = "/")
    public String getAllProduct(Model model) {
        List<Product> productList = productRepository.findAll();
        model.addAttribute("product", productList);
        return "homepage";
    }

    @RequestMapping(value = "/type/{productType}")
    public String showProductsByType(@PathVariable String productType, Model model) {
        List<Product> productList = productRepository.findByProductType(productType);
        model.addAttribute("product", productList);
        return "producttype";
    }

    @RequestMapping(value = "/search")
    public String showSearchPopup(Model model) {
        return "search";
    }

    @RequestMapping(value = "/cart")
    public String showCart(Model model) {
        return "cart1";
    }

    @GetMapping(value = "/")
    public String homePage() {
        return "homepage";
    }

    @GetMapping(value = "/close")
    public String closePopUp() {
        return "homepage";
    }

    @GetMapping(value = "/sort")
    public String sort() {
        return "sort";
    }
}
