package br.com.gabriel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gabriel.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
