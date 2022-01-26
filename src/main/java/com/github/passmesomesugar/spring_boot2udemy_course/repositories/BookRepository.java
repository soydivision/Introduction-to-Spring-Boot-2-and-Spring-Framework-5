package com.github.passmesomesugar.spring_boot2udemy_course.repositories;

import com.github.passmesomesugar.spring_boot2udemy_course.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
