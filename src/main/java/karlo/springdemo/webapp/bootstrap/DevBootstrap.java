package karlo.springdemo.webapp.bootstrap;

import karlo.springdemo.webapp.model.Author;
import karlo.springdemo.webapp.model.Book;
import karlo.springdemo.webapp.model.Publisher;
import karlo.springdemo.webapp.repositories.AuthorRepository;
import karlo.springdemo.webapp.repositories.BookRepository;
import karlo.springdemo.webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initData(){

        Publisher publisher = new Publisher();
        publisher.setName("Publisher");
        publisher.setAddress("Zagreb");

        publisherRepository.save(publisher);

        Author eric = new Author("Eric", "Evans");
        Book domainDriven = new Book ("Domain Driver Design",  "1234",  publisher);
        eric.getBooks().add(domainDriven);
        domainDriven.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(domainDriven);

        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J2EE Development without EJB","12344", publisher);
        rod.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
