package br.com.gabriel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gabriel.model.CourseDetail;

@Repository
public interface CourseDetailRepository extends JpaRepository<CourseDetail, Long> {

}
