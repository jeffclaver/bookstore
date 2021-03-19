package br.com.bookstoremanager.bookstore.persistence.entity;

import javax.persistence.*;
import java.util.List;
import java.util.function.Function;

@Entity
public class Author extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false, unique = true)
    private String name;

    @Column(columnDefinition = "Integer default 18")
    private int age;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Book> books;

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
