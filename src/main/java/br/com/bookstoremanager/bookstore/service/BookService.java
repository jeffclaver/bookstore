package br.com.bookstoremanager.bookstore.service;

import br.com.bookstoremanager.bookstore.model.request.BookRequest;
import br.com.bookstoremanager.bookstore.model.response.BookReponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BookService {

    BookReponse create(BookRequest bookRequest);

    Page<BookReponse> getAll(Pageable pageable);

    Optional<BookReponse> update(Long isbn, BookRequest bookRequest);

    Optional<BookReponse> get(Long isbn);

    boolean delete(Long isbn);

}
