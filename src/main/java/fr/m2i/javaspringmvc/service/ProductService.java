package fr.m2i.javaspringmvc.service;

import fr.m2i.javaspringmvc.model.Product;
import fr.m2i.javaspringmvc.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository repo;
    private final UserService userService;

    @Autowired
    public ProductService(ProductRepository repo, UserService userService) {
        this.repo = repo;
        this.userService = userService;
    }

    //Lister les produits
    public List<Product> findAll() {
        return repo.findAll();
    }
    //trouver produit par id
    //save
    //buy product
    // => est-ce que j'ai assez de crédit ? stock ? existe ?
}
