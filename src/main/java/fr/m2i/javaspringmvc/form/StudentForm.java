package fr.m2i.javaspringmvc.form;

import javax.validation.constraints.*;

public class StudentForm {

    @Min(value = 0, message = "Please enter a valid age")
    @NotNull(message = "Age field is mandatory")
    private Integer age;

    @NotBlank(message = "Name field is mandatory")
    private String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
