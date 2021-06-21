package br.com.gabriel.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long courseId;

	@NotBlank
	private String name;

	@OneToMany(mappedBy = "subjectDetailPK.course")
	private Set<SubjectDetail> subjectDetails = new HashSet<SubjectDetail>();

	@OneToMany(mappedBy = "courseDetailPK.course")
	private Set<CourseDetail> courseDetails = new HashSet<CourseDetail>();

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<SubjectDetail> getSubjectDetails() {
		return subjectDetails;
	}

	public void setSubjectDetails(Set<SubjectDetail> subjectDetails) {
		this.subjectDetails = subjectDetails;
	}

	public Set<CourseDetail> getCourseDetails() {
		return courseDetails;
	}

	public void setCourseDetails(Set<CourseDetail> courseDetails) {
		this.courseDetails = courseDetails;
	}

}
