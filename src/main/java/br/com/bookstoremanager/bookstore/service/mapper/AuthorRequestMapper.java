package br.com.bookstoremanager.bookstore.service.mapper;

import br.com.bookstoremanager.bookstore.model.request.AuthorRequest;
import br.com.bookstoremanager.bookstore.persistence.entity.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorRequestMapper implements Mapper<AuthorRequest, Author>{

    @Override
    public Author map(AuthorRequest input) {
        if(input == null){
            return null;
        }

        Author author = new Author();
        author.setName(input.getName());
        author.setAge(input.getAge());

        return author;
    }
}
