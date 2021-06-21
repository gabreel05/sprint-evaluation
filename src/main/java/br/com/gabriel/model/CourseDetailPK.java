package br.com.gabriel.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class CourseDetailPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "courseId")
	private Course course;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "teamId")
	private Team team;

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

}
