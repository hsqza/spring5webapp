package com.hubert.spring5webApp.repository;

import com.hubert.spring5webApp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
