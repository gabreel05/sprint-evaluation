package br.com.gabriel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gabriel.model.SubjectDetail;

@Repository
public interface SubjectDetailRepository extends JpaRepository<SubjectDetail, Long> {

}
