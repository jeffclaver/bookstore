package br.com.bookstoremanager.bookstore.service.mapper;

public interface Mapper<A, B> {
    B map(A input);
}
