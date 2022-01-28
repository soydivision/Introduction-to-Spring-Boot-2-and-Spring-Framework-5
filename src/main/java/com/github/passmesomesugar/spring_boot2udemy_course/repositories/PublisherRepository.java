package com.github.passmesomesugar.spring_boot2udemy_course.repositories;

import com.github.passmesomesugar.spring_boot2udemy_course.domain.Book;
import com.github.passmesomesugar.spring_boot2udemy_course.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
