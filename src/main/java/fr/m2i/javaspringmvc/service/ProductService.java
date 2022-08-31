package fr.m2i.javaspringmvc.service;

import fr.m2i.javaspringmvc.exception.InsufficientBalanceException;
import fr.m2i.javaspringmvc.exception.NotEnoughStockException;
import fr.m2i.javaspringmvc.exception.NotFoundException;
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
    public Product findById(Long id) throws NotFoundException {
        Product product = repo.findById(id).orElseThrow(() -> new NotFoundException("Product with id : " + id + " doesn't exist"));

        return product;
    }

    //save
    public void save(Product product) {
        repo.save(product);
    }

    //buy product
    // => est-ce que j'ai assez de crédit ? stock ? existe ?
    public void buyProduct(Long id) throws Exception {

        Product product = findById(id);

        if (product.getQuantity() < 1) {
            throw new NotEnoughStockException("Product with id " + product.getId() + " has no more stock ");
        }

        if (userService.getBalance() < product.getPrice()) {
            throw new InsufficientBalanceException("User do not have enough balance for the product with id " + product.getId());
        }

        product.setQuantity(product.getQuantity() - 1);
        userService.decreaseBalance(product.getPrice());
        save(product);
    }
}
