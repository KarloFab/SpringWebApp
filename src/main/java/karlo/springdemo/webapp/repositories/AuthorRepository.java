package karlo.springdemo.webapp.repositories;

import karlo.springdemo.webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
