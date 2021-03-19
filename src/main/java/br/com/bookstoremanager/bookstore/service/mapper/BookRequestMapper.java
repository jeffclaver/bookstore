package br.com.bookstoremanager.bookstore.service.mapper;

import br.com.bookstoremanager.bookstore.model.request.BookRequest;
import br.com.bookstoremanager.bookstore.persistence.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookRequestMapper implements Mapper<BookRequest, Book> {


    @Override
    public Book map(BookRequest input) {
        if (input == null){
            return null;
        }
        Book book = new Book();
        book.setIsbn(input.getIsbn());
        book.setName(input.getName());
        book.setPage(input.getPage());
        book.setChapter(input.getChapter());

        return book;
    }
}
