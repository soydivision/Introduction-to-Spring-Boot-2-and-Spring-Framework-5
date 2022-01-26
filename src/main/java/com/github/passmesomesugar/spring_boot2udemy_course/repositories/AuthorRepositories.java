package com.github.passmesomesugar.spring_boot2udemy_course.repositories;

import com.github.passmesomesugar.spring_boot2udemy_course.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepositories extends CrudRepository<Author, Long> {
}
