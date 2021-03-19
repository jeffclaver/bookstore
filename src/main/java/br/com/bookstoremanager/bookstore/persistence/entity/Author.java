package br.com.bookstoremanager.bookstore.persistence.entity;

import javax.persistence.*;
import java.util.function.Function;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false, unique = true)
    private String name;

    @Column(columnDefinition = "Integer default 0")
    private int age;

    public <R> R map(Function<Author, R> funcAuthor){
        return funcAuthor.apply(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
