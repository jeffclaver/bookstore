package br.com.bookstoremanager.bookstore.service;

import br.com.bookstoremanager.bookstore.model.request.BookRequest;
import br.com.bookstoremanager.bookstore.model.response.BookReponse;
import br.com.bookstoremanager.bookstore.persistence.entity.Book;
import br.com.bookstoremanager.bookstore.persistence.repository.BookRepository;
import br.com.bookstoremanager.bookstore.service.mapper.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    private static final Logger LOGGER = LoggerFactory.getLogger(BookService.class);

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private Mapper<BookRequest, Book> bookRequestMapper;

    @Autowired
    private Mapper<Book, BookReponse> bookResponseMapper;


    @Override
    public BookReponse create(BookRequest bookRequest) {
        LOGGER.info("Cadastro de livros");
        Assert.notNull(bookRequest, "Request de autor inválida");
        Book book = this.bookRequestMapper.map(bookRequest);
        return bookRepository.saveAndFlush(book).map((Book input)->this.bookResponseMapper.map(input));
    }

    @Override
    public Page<BookReponse> getAll(Pageable pageable) {
        LOGGER.info("Busca de todos os livros");
        Assert.notNull(pageable, "Página inválida");
        return bookRepository.findAll(pageable).map(book -> this.bookResponseMapper.map(book));
    }

    @Override
    public Optional<BookReponse> update(Long isbn, BookRequest bookRequest) {
        LOGGER.info("Atualizar o cadastro do livro");
        Assert.notNull(isbn, "Isbn inválido");
        Book bookUpdate= this.bookRequestMapper.map(bookRequest);

        return bookRepository.findById(isbn)
                .map(book -> {
                    book.setName(bookUpdate.getName());
                    book.setPage(bookUpdate.getPage());
                    book.setChapter(bookUpdate.getChapter());
                    return this.bookResponseMapper.map(bookRepository.saveAndFlush(book));
                });
    }

    @Override
    public Optional<BookReponse> get(Long isbn) {
        LOGGER.info("Busca de livro");
        Assert.notNull(isbn,"Isbn inválido");
        return bookRepository.findById(isbn)
                .map(this.bookResponseMapper::map);
    }

    @Override
    public boolean delete(Long isbn) {
        LOGGER.info("Remover livro");
        Assert.notNull(isbn,"Isbn inválido");
        try {
            bookRepository.deleteById(isbn);
            return true;
        }
        catch (Exception e){
            LOGGER.warn("Erro ao remover o livro {}",isbn);
        }
        return false;
    }
}
