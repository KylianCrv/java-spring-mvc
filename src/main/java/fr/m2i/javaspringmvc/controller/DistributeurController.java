package fr.m2i.javaspringmvc.controller;

import fr.m2i.javaspringmvc.form.BuyForm;
import fr.m2i.javaspringmvc.form.UserForm;
import fr.m2i.javaspringmvc.model.Product;
import fr.m2i.javaspringmvc.service.ProductService;
import fr.m2i.javaspringmvc.service.UserService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @ModelAttribute("userForm")
    public UserForm addUserForm() {
        return new UserForm();
    }

    @ModelAttribute("buyForm")
    public BuyForm addBuyForm() {
        return new BuyForm();
    }

    @PostMapping("/addBalance")
    public String addBalance(@ModelAttribute @Valid UserForm user,
            BindingResult result, ModelMap model) throws Exception {

        if (result.hasErrors()) {
            return "distributeur";
        }

        Double credToAdd = user.getBalance();

        try {
            userService.addBalance(credToAdd);
            model.addAttribute("balance", userService.getBalance());
        } catch (Exception e) {

        }
        return "distributeur";
    }
}
