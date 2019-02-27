package karlo.springdemo.webapp.repositories;

import karlo.springdemo.webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
