package br.com.bookstoremanager.bookstore.service;

import br.com.bookstoremanager.bookstore.model.request.AuthorRequest;
import br.com.bookstoremanager.bookstore.model.response.AuthorResponse;
import br.com.bookstoremanager.bookstore.persistence.entity.Author;
import br.com.bookstoremanager.bookstore.persistence.repository.AuthorRepository;
import br.com.bookstoremanager.bookstore.service.mapper.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorService.class);

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private Mapper<AuthorRequest, Author> authorRequestMapper;

    @Autowired
    private Mapper<Author,AuthorResponse> authorResponseMapper;

    @Override
    public AuthorResponse create(AuthorRequest authorRequest) {
        LOGGER.info("Criando cadastro do autor");
        Assert.notNull(authorRequest,"Request do autor inválida");
        Author author=this.authorRequestMapper.map(authorRequest);
        return authorRepository.saveAndFlush(author).map((Author input) ->this.authorResponseMapper.map(input));
    }

    @Override
    public Page<AuthorResponse> getAll(Pageable pageable) {
        LOGGER.info("Buscando todos os autores");
        Assert.notNull(pageable,"Página inválida");
        return authorRepository.findAll(pageable).map(author -> this.authorResponseMapper.map(author));
    }

    @Override
    public Optional<AuthorResponse> update(Long id, AuthorRequest authorRequest) {
        LOGGER.info("Atualizando o cadastro do autor");
        Assert.notNull(id,"ID Inválido");
        Author authorUpdate = this.authorRequestMapper.map(authorRequest);

        return authorRepository.findById(id)
                .map(author -> {
                    author.setName(authorUpdate.getName());
                    author.setAge(authorUpdate.getAge());
                    return this.authorResponseMapper.map(authorRepository.saveAndFlush(author));
                });
    }

    @Override
    public Optional<AuthorResponse> get(Long id) {
        LOGGER.info("Buscando um autor");
        Assert.notNull(id, "ID Inválido");
        return authorRepository.findById(id)
                .map(this.authorResponseMapper::map);
    }

    @Override
    public boolean delete(Long id) {
        LOGGER.info("Remover autor");
        Assert.notNull(id, "ID Inválido");
        try{
            authorRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            LOGGER.warn("Erro ao remover o autor {}", id);
        }

        return false;
    }

}
