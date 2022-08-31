package fr.m2i.javaspringmvc.controller;

import fr.m2i.javaspringmvc.exception.InsufficientBalanceException;
import fr.m2i.javaspringmvc.exception.NotEnoughStockException;
import fr.m2i.javaspringmvc.exception.NotFoundException;
import fr.m2i.javaspringmvc.form.BuyForm;
import fr.m2i.javaspringmvc.form.UserForm;
import fr.m2i.javaspringmvc.model.Product;
import fr.m2i.javaspringmvc.service.ProductService;
import fr.m2i.javaspringmvc.service.UserService;
import java.util.ArrayList;
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
    public Double addBalanceBean() throws NotFoundException {
        try {

            return userService.getBalance();

        } catch (NotFoundException e) {

            return 0.0;

        }
    }

    @ModelAttribute("products")
    public List<Product> addProductsBean() throws Exception {
        try {

            return productService.findAll();

        } catch (Exception e) {

            return new ArrayList();

        }
    }

    @ModelAttribute("userForm")
    public UserForm addUserFormBean() {
        return new UserForm();
    }

    @ModelAttribute("buyForm")
    public BuyForm addBuyForm() {
        return new BuyForm();
    }

    @PostMapping("/addBalance")
    public String addBalance(@ModelAttribute @Valid UserForm user,
            BindingResult result) throws Exception {

        if (result.hasErrors()) {
            return "distributeur";
        }

        try {
            userService.addBalance(user.getBalance());
            return "redirect:distributeur";

        } catch (NotFoundException e) {
            result.rejectValue("balance", null, "Une erreur est survenue lors de l'ajout de crédit ");
            return "distributeur";
        }
    }

    @PostMapping("/buyProduct")
    public String buyProduct(@ModelAttribute("buyForm") @Valid BuyForm buyForm,
            BindingResult result) throws Exception {

        if (result.hasErrors()) {
            return "distributeur";
        }

        String errorMessage = "";
        try {
            productService.buyProduct(buyForm.getId());
            return "redirect:distributeur";

        } catch (NotFoundException nfe) {
            errorMessage = "Le produit demandé n'existe pas";
        } catch (NotEnoughStockException nese) {
            errorMessage = "Le produit demandé n'est plus en stock";
        } catch (InsufficientBalanceException ibe) {
            errorMessage = "Vous manquez de crédit pour acheter ce produit";
        } catch (Exception e) {
            errorMessage = "une erreur est survenue lors de l'achat du produit";
        }
        result.rejectValue("id", null, errorMessage);
        return "distributeur";
    }
}
