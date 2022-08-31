package fr.m2i.javaspringmvc.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class BuyForm {

    @Min(value = 1, message = "Veuillez entrer un numéro de produit valide")
    @NotNull(message = "Le champ numero de produit est obligatoire")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
