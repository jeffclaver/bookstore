package br.com.bookstoremanager.bookstore.model.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

public class AuthorRequest {

    @NotBlank
    @ApiModelProperty(value = "Nome do autor, não pode ser vazio")
    private String name;

    @NotBlank
    @ApiModelProperty(value = "Idade do autor, não pode ser vazio")
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
