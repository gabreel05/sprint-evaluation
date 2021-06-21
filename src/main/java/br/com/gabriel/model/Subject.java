package br.com.gabriel.model;

import java.io.Serializable;
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
public class Subject implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long subjectId;

	@NotBlank
	private String name;

	@OneToMany(mappedBy = "subjectDetailPK.subject", cascade = CascadeType.ALL)
	private Set<SubjectDetail> subjectDetails = new HashSet<SubjectDetail>();

	public boolean isFromCourse(Long courseId) {
		return !(this.subjectDetails.stream().filter(x -> x.getSubjectDetailPK().getCourse().getCourseId() == courseId)
				.collect(Collectors.toList()).isEmpty());
	}

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
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

}
