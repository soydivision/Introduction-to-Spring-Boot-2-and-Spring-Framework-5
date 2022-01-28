package com.github.passmesomesugar.spring_boot2udemy_course.bootstrap;

import com.github.passmesomesugar.spring_boot2udemy_course.domain.Author;
import com.github.passmesomesugar.spring_boot2udemy_course.domain.Book;
import com.github.passmesomesugar.spring_boot2udemy_course.domain.Publisher;
import com.github.passmesomesugar.spring_boot2udemy_course.repositories.AuthorRepository;
import com.github.passmesomesugar.spring_boot2udemy_course.repositories.BookRepository;
import com.github.passmesomesugar.spring_boot2udemy_course.repositories.PublisherRepository;
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
        System.out.println("Starting Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("SFG publishing");
        publisher.setCity("Saint Petersburg");
        publisher.setState("FL");

        publisherRepository.save(publisher);
        System.out.println("Publisher count" + publisherRepository.count());

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain driven design", "1234");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "234234");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Publisher number of books" + publisher.getBooks().size());
    }
}
