package fr.m2i.javaspringmvc.form;

import javax.validation.constraints.Min;

public class BuyForm {

    @Min(value = 0, message = "Enter a correct product")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
