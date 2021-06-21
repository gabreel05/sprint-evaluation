package br.com.gabriel.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.gabriel.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	@Modifying
	@Query("UPDATE Student s SET s.name = ?1, s.gender = ?2, s.registration = ?3, s.birthdate = ?4 WHERE s.studentId = ?5")
	void updateStudentById(String name, String gender, String registration, LocalDate birthdate, Long studentId);
	
}
