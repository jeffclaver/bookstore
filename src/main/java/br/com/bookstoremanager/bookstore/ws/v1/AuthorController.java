package br.com.bookstoremanager.bookstore.ws.v1;

import br.com.bookstoremanager.bookstore.model.request.AuthorRequest;
import br.com.bookstoremanager.bookstore.model.response.AuthorResponse;
import br.com.bookstoremanager.bookstore.service.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorController.class);

    @Autowired
    private AuthorService authorService;

    @PostMapping
    public ResponseEntity<AuthorResponse> create(@RequestBody AuthorRequest authorRequest){
        LOGGER.info("Author criado com sucesso");
        return ResponseEntity.ok(authorService.create(authorRequest));
    }

    @GetMapping
    public ResponseEntity<Page<AuthorResponse>> getAll(Pageable pageable){
        LOGGER.info("Buscando os autores");
        Page<AuthorResponse> authorResponses = authorService.getAll(pageable);
        return ResponseEntity.ok(authorResponses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorResponse> update(@PathVariable("id")Long id, @RequestBody AuthorRequest authorRequest){
        LOGGER.info("Atualizando o autor");
        Optional<AuthorResponse> updateAuthor = authorService.update(id, authorRequest);
        if(!updateAuthor.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updateAuthor.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponse>get(@PathVariable("id")Long id){
        LOGGER.info("Buscando um autor");
        Optional<AuthorResponse> authorResponse = authorService.get(id);
        if(!authorResponse.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(authorResponse.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id")Long id){
        LOGGER.info("Deletando um autor");
        if (authorService.delete(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
