package fr.m2i.javaspringmvc.controller;

import fr.m2i.javaspringmvc.model.Product;
import fr.m2i.javaspringmvc.service.ProductService;
import fr.m2i.javaspringmvc.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class DistributeurController {

    private final UserService userService;
    private final ProductService productService;

    @Autowired
    public DistributeurController(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }

    @GetMapping("/distributeur")
    public String showDistributeurPage() {
        return "distributeur";
    }

    @ModelAttribute("balance")
    public Double addBalanceBean() throws Exception {
        return userService.getBalance();
    }

    @ModelAttribute("products")
    public List<Product> addProductsBean() throws Exception {
        return productService.findAll();
    }
}
