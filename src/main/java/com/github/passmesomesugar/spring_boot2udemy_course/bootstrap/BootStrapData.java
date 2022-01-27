package com.github.passmesomesugar.spring_boot2udemy_course.bootstrap;

import com.github.passmesomesugar.spring_boot2udemy_course.domain.Author;
import com.github.passmesomesugar.spring_boot2udemy_course.domain.Book;
import com.github.passmesomesugar.spring_boot2udemy_course.repositories.AuthorRepository;
import com.github.passmesomesugar.spring_boot2udemy_course.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain driven design", "1234");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "234234");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Number of books" + bookRepository.count());

    }
}
