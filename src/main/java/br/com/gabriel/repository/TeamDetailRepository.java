package br.com.gabriel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gabriel.model.TeamDetail;

@Repository
public interface TeamDetailRepository extends JpaRepository<TeamDetail, Long> {

}
