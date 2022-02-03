package com.hubert.spring5webApp.bootstrap;

import com.hubert.spring5webApp.domain.Author;
import com.hubert.spring5webApp.domain.Book;
import com.hubert.spring5webApp.domain.Publisher;
import com.hubert.spring5webApp.repository.AuthorRepository;
import com.hubert.spring5webApp.repository.BookRepository;
import com.hubert.spring5webApp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;

  private final PublisherRepository publisherRepository;

  public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }

  @Override
  public void run(String... args) throws Exception {

    System.out.println("Started in Bootstrap");

    Publisher publisher = new Publisher();
    publisher.setName("SFG Publishing");
    publisher.setCity("St Petersburg");
    publisher.setState("FL");

    publisherRepository.save(publisher);
    System.out.println("Publisher Count: " + publisherRepository.count());

    Author eric = new Author("Eric", "Evans");
    Book desert = new Book("Domain Driven Design", "1508966");
    eric.getBooks().add(desert);
    desert.getAuthors().add(eric);

    desert.setPublisher(publisher);
    publisher.getBooks().add(desert);

    authorRepository.save(eric);
    bookRepository.save(desert);
    publisherRepository.save(publisher);

    Author rod = new Author("Rod", "Johnson");
    Book noEJB = new Book("J2EE Development without EJB", "39545486999417");
    rod.getBooks().add(noEJB);
    noEJB.getAuthors().add(rod);

    noEJB.setPublisher(publisher);
    publisher.getBooks().add(noEJB);

    authorRepository.save(rod);
    bookRepository.save(noEJB);
    publisherRepository.save(publisher);

    System.out.println("Number of books " + bookRepository.count());
    System.out.println("Publisher number of books " + publisher.getBooks().size());
  }
}
