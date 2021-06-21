package br.com.gabriel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gabriel.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
