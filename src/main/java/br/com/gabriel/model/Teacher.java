package br.com.gabriel.model;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long teacherId;

	@NotBlank
	private String name;

	@NotBlank
	private String gender;

	@NotBlank
	private String register;

	@OneToMany(mappedBy = "teamDetailPK.teacher")
	private Set<TeamDetail> teamDetails = new HashSet<TeamDetail>();
	
	
	public boolean isFromStudent(Long studentId) {
		return !(this.teamDetails.stream().filter(x -> x.getTeamDetailPK().getStudent().getStudentId() == studentId)
				.collect(Collectors.toList()).isEmpty());
	}
	
	public Long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
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

	public String getRegister() {
		return register;
	}

	public void setRegister(String register) {
		this.register = register;
	}

	public Set<TeamDetail> getTeamDetails() {
		return teamDetails;
	}

	public void setTeamDetails(Set<TeamDetail> teamDetails) {
		this.teamDetails = teamDetails;
	}

}
