package karlo.springdemo.webapp.repositories;

import karlo.springdemo.webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
