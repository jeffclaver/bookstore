package br.com.bookstoremanager.bookstore.ws.v1;

import br.com.bookstoremanager.bookstore.model.request.BookRequest;
import br.com.bookstoremanager.bookstore.model.response.BookReponse;
import br.com.bookstoremanager.bookstore.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookService.class);

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<BookReponse> create(@RequestBody BookRequest bookRequest){
        LOGGER.info("Livro cadastrado com sucesso");
        return ResponseEntity.ok(bookService.create(bookRequest));
    }

    @GetMapping
    public ResponseEntity<Page<BookReponse>> getAll(Pageable pageable){
        LOGGER.info("Busca de livro");
        Page<BookReponse> bookReponses = bookService.getAll(pageable);
        return ResponseEntity.ok(bookReponses);
    }

    @PutMapping("{/isbn}")
    public ResponseEntity<BookReponse> update(@PathVariable("isbn")Long isbn, @RequestBody BookRequest bookRequest){
        LOGGER.info("Atualização de livro");
        Optional<BookReponse> updateBook = bookService.update(isbn, bookRequest);
        if (!updateBook.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updateBook.get());
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<BookReponse> get(@PathVariable("isbn")Long isbn){
        LOGGER.info("Busca de um único livro");
        Optional<BookReponse> bookReponse = bookService.get(isbn);
        if (!bookReponse.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bookReponse.get());
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<Void> delete(@PathVariable("isbn")Long isbn){
        LOGGER.info("Deletando um livro");
        if (bookService.delete(isbn)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
