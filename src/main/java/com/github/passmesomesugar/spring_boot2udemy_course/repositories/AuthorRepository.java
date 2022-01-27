package com.github.passmesomesugar.spring_boot2udemy_course.repositories;

import com.github.passmesomesugar.spring_boot2udemy_course.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
