package br.com.bookstoremanager.bookstore.service.mapper;

import br.com.bookstoremanager.bookstore.model.response.BookReponse;
import br.com.bookstoremanager.bookstore.persistence.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookResponseMapper implements Mapper<Book, BookReponse> {
    @Override
    public BookReponse map(Book input) {
        if(input == null){
            return null;
        }
        BookReponse bookReponse = new BookReponse();
        bookReponse.setId(input.getId());
        bookReponse.setIsbn(input.getIsbn());
        bookReponse.setName(input.getName());
        bookReponse.setPage(input.getPage());
        bookReponse.setChapter(input.getChapter());

        return bookReponse;
    }
}
