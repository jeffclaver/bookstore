package br.com.bookstoremanager.bookstore.service;

import br.com.bookstoremanager.bookstore.model.request.AuthorRequest;
import br.com.bookstoremanager.bookstore.model.response.AuthorResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface AuthorService {

    AuthorResponse create(AuthorRequest authorRequest);

    Page<AuthorResponse> getAll(Pageable pageable);

    Optional<AuthorResponse> update(Long id, AuthorRequest authorRequest);

    Optional<AuthorResponse> get(Long id);

    boolean delete(Long id);
}
