package br.com.bookstoremanager.bookstore.persistence.repository;

import br.com.bookstoremanager.bookstore.persistence.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>  {
}
