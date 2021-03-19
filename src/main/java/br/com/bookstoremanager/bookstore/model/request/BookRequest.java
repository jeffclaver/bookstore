package br.com.bookstoremanager.bookstore.model.request;

import javax.validation.constraints.NotBlank;

public class BookRequest {

    @NotBlank
    private Long isbn;

    @NotBlank
    private String name;

    @NotBlank
    private int page;

    @NotBlank
    private int chapter;

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getChapter() {
        return chapter;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }
}
