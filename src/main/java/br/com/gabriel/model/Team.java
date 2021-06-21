package br.com.gabriel.model;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long teamId;

	@NotBlank
	private String name;

	@OneToMany(mappedBy = "courseDetailPK.team", cascade = CascadeType.ALL)
	private Set<CourseDetail> courseDetails = new HashSet<CourseDetail>();

	@OneToMany(mappedBy = "teamDetailPK.team", cascade = CascadeType.ALL)
	private Set<TeamDetail> teamDetails = new HashSet<TeamDetail>();
	
	public boolean isFromStudent(Long studentId) {
		return !(this.teamDetails.stream().filter(x -> x.getTeamDetailPK().getStudent().getStudentId() == studentId)
				.collect(Collectors.toList()).isEmpty());
	}
	
	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<CourseDetail> getCourseDetails() {
		return courseDetails;
	}

	public void setCourseDetails(Set<CourseDetail> courseDetails) {
		this.courseDetails = courseDetails;
	}

	public Set<TeamDetail> getTeamDetails() {
		return teamDetails;
	}

	public void setTeamDetails(Set<TeamDetail> teamDetails) {
		this.teamDetails = teamDetails;
	}

}
