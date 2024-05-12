package se206.group01.mobileworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import se206.group01.mobileworld.model.Product;
import se206.group01.mobileworld.repository.ProductRepository;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    ProductRepository productRepository;

    @RequestMapping("/")
    public String homepage(Model model) {
        List<Product> productList = productRepository.findAll();
        model.addAttribute("product", productList);
        return "homepage";
    }

    @RequestMapping("/type/{productType}")
    public String showProductsByType(@PathVariable String productType, Model model) {
        List<Product> productList = productRepository.findByProductType(productType);
        model.addAttribute("product", productList);
        return "producttype";
    }
}

