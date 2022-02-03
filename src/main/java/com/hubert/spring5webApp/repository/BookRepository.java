package com.hubert.spring5webApp.repository;

import com.hubert.spring5webApp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
