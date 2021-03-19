package br.com.bookstoremanager.bookstore.model.request;

import javax.validation.constraints.NotBlank;

public class AuthorRequest {

    @NotBlank
    private String name;

    @NotBlank
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
