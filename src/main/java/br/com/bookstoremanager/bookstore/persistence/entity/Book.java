package br.com.bookstoremanager.bookstore.persistence.entity;

import javax.persistence.*;
import java.util.function.Function;

@Entity
public class Book extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "isbn", nullable = false)
    private Long isbn;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(columnDefinition = "integer default 1")
    private int page;

    @Column(columnDefinition = "integer default 1")
    private int chapter;

    @ManyToOne(cascade = {CascadeType.MERGE})
    private Author author;

    public <R> R map(Function<Book, R> funcBook){
        return funcBook.apply(this);
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public Long getIsbn() {return isbn;}

    public void setIsbn(Long isbn) {this.isbn = isbn;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public int getPage() {return page;}

    public void setPage(int page) {this.page = page;}

    public int getChapter() {return chapter;}

    public void setChapter(int chapter) {this.chapter = chapter;}
}
