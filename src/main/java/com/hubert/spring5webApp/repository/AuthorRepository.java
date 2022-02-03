package com.hubert.spring5webApp.repository;

import com.hubert.spring5webApp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
