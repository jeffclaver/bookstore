package br.com.bookstoremanager.bookstore.persistence.repository;

import br.com.bookstoremanager.bookstore.persistence.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
