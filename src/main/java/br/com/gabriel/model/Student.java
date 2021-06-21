package br.com.gabriel.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studentId;

	@NotBlank
	private String name;

	@NotBlank
	private String gender;

	@NotBlank
	private String registration;

	@NotNull
	private LocalDate birthdate;

	@OneToMany(mappedBy = "teamDetailPK.student")
	private Set<TeamDetail> teamDetails = new HashSet<TeamDetail>();

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public Set<TeamDetail> getTeamDetails() {
		return teamDetails;
	}

	public void setTeamDetails(Set<TeamDetail> teamDetails) {
		this.teamDetails = teamDetails;
	}

}
