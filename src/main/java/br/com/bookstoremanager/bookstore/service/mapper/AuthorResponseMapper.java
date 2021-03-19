package br.com.bookstoremanager.bookstore.service.mapper;

import br.com.bookstoremanager.bookstore.model.response.AuthorResponse;
import br.com.bookstoremanager.bookstore.persistence.entity.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorResponseMapper implements Mapper<Author, AuthorResponse>{

    @Override
    public AuthorResponse map(Author input) {
        if(input == null){
            return null;
        }
        AuthorResponse authorResponse = new AuthorResponse();
        authorResponse.setId(input.getId());
        authorResponse.setName(input.getName());
        authorResponse.setAge(input.getAge());

        return authorResponse;
    }
}
