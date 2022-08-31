package fr.m2i.javaspringmvc.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class UserForm {

    @Min(value = 0, message = "Enter a correct value")
    @NotNull(message = "Cannot bet empty")
    private Double balance;

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

}
